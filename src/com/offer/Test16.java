package com.offer;

public class Test16 {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }

        double y = quickMul(x, N / 2);

        return N % 2 == 0 ? (y * y) : (y * y * x);
    }


    public static void main(String[] args) {
        Test16 test16 = new Test16();
        double result = test16.myPow(4, 7);
        System.out.println(result);
    }

}
