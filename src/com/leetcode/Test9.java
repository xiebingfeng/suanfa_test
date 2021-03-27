package com.leetcode;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

public class Test9 {

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        System.out.println(test9.isPalindrome(10));
    }
}
