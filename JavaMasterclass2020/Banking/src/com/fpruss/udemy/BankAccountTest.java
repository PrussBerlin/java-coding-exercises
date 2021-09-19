package com.fpruss.udemy;

import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    // wird vor allen Methoden nur einmal ausgeführt
    @BeforeClass
    public static void beforeClass() {
        System.out.println("this exucutes before any test case. Count = " + count++);
    }
    // wird vor jeder Testmethode ausgeführt
    @Before
    public void setup() {
        account = new BankAccount("Friedel", "Pruss", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() {
        double balance = account.deposit(200, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");
    }

    @Test
    public void getBalance_withdraw() {
        account.withdraw(200, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_deposit() {
        account.deposit(200, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }
    @Test
    public void isChecking_true() {
        assertTrue("account is not Checking account", account.isChecking());
    }

    // @After wird nach jeder Testmethode ausgeführt
    @After
    public void teardown() {
        System.out.println("Count = " + count++);
    }
    // @AfterClass wird nach allen Methoden, ganz zum Schluss nur einmal ausgeführt
    @AfterClass
    public static void afterClass() {
        System.out.println("This exceutes after any test cases. Count = " + count++);
    }
}