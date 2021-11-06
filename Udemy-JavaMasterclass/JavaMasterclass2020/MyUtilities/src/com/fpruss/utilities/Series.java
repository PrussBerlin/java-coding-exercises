package com.fpruss.utilities;

public class Series {

    public static long nSum(int n) {
        if(n < 0) {
            System.out.println("please enter a positive number");
            return -1;
        }
        //gaussche Summenformel, geil
        return (n * (n+1)) / 2;
    }

    public static long factorialRec(int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            System.out.println("please enter a positive number");
            return -1;
        }
        return n * factorialRec(n-1);
    }

    public static long factorialIterative(int n) {
        if(n < 0) {
            System.out.println("please enter a positive number");
            return -1;
        }
        long sum = 1;
        while(n > 0) {
            sum *= n;
            n--;
        }
        return sum;
    }

    public static long fibonacciRec(int n) {
        if(n < 0) {
            System.out.println("please enter a positive number");
            return -1;
        }
        return (n <= 1) ? n : fibonacciRec(n-1) + fibonacciRec(n-2);
    }

    public static long fibonacciIterative(int n) {
        if(n < 0) {
            System.out.println("please enter a positive number");
            return -1;
        }
        long sum = n;
        long f0 = 0;
        long f1 = 1;
        for(int i = 2; i <= n; i++) {
            sum = f0 + f1;
            f0 = f1;
            f1 = sum;
        }
        return sum;
    }
}
