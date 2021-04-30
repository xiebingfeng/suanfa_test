package com.leetcode;

public class Test50 {

    public double myPow(double x, int n) {
        long N = n;
        if (N == 0 || x == 1) {
            return 1;
        }

        if (n > 0) {
            return myPow2(x, n);
        } else {
            return 1 / myPow2(x, -n);
        }
    }

    public double myPow2(double x, long n) {
        if (n == 1) {
            return x;
        }

        double t = myPow2(x, n / 2);

        if (n % 2 == 1) {
            return x * t * t;
        }

        return t * t;
    }

    public static void main(String[] args) {
        Test50 test = new Test50();
        double result = test.myPow(2.1, 3);
        System.out.println(result);
    }

}
