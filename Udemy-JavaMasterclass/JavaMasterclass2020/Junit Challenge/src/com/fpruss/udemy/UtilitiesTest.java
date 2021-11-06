package com.fpruss.udemy;

import jdk.jshell.execution.Util;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private UtilitiesClient util;
    private String testString;
    private String testString2;

    @Before
    public void setUp() {
        util = new Utilities();
    }
    @org.junit.Test
    public void everyNthChar() {
        assertArrayEquals(new char[]{'e', 'l'}, util.everyNthChar("Hello".toCharArray(), 2));
    }

    @org.junit.Test
    public void everyNthChar_n_GreaterThanArray() {
        assertArrayEquals("Hello".toCharArray(), util.everyNthChar("Hello".toCharArray(), 6));
    }

    @org.junit.Test
    public void removePairs_checkNull() {
        assertNull("Did not get null returned, argument passed was null", util.removePairs(null));
    }

    @org.junit.Test
    public void converter() {
       assertEquals(300, util.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() {
        util.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNotNull(util.nullIfOddLength("1234"));
        assertNull(util.nullIfOddLength("12345"));
    }
}