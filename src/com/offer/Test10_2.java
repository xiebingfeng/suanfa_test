package com.offer;

import java.util.HashMap;

public class Test10_2 {

    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int a = 0;
        int b = 0;
        if (hashMap.containsKey(n - 1)) {
            a = hashMap.get(n - 1);
        } else {
            a = numWays(n - 1);
            hashMap.put(n - 1, a);
        }

        if (hashMap.containsKey(n - 2)) {
            b = hashMap.get(n - 2);
        } else {
            b = numWays(n - 2);
            hashMap.put(n - 2, b);
        }
        return (a + b) % 1000000007;
    }

    public static void main(String[] args) {
        Test10_2 test10_2 = new Test10_2();
        int result = test10_2.numWays(5);
        System.out.println(result);
    }

}
