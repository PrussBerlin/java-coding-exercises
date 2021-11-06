package com.fpruss.udemy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesTestParamterized {

    private UtilitiesClient util;
    // die Reiohenfolge der Fields ist egal, nur die Reihenfolge im Konstruktor zählt für die Initialisierung duch die
    // parametterized Collection
    private String expectedString;
    private String testString;

    public UtilitiesTestParamterized(String testString, String expectedString) {
        this.expectedString = expectedString;
        this.testString = testString;
    }

    @Before
    public void setUp() {
        util = new Utilities();
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {"AABCCDEE", "ABCDE"},
                {"AABCBDDAE", "ABCBDAE"},
                {"112234", "1234"},
                {"11213324", "121324"},
                {"AaBbB2", "AaBbB2"},
                {"2", "2"},
                {"", ""}
        });
    }

    @Test
    public void removePairs() {
        assertEquals(expectedString, util.removePairs(testString));
    }
}
