package com.offer;

import java.util.HashMap;

public class Test10_1 {

    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 0;
        if (hashMap.containsKey(n - 1)) {
            a = hashMap.get(n - 1);
        } else {
            a = fib(n - 1);
            hashMap.put(n - 1, a);
        }

        if (hashMap.containsKey(n - 2)) {
            b = hashMap.get(n - 2);
        } else {
            b = fib(n - 2);
            hashMap.put(n - 2, b);
        }
        return (a + b) % 1000000007;
    }

    public static void main(String[] args) {
        Test10_1 test10_1 = new Test10_1();
        int result = test10_1.fib(5);
        System.out.println(result);
    }

}
