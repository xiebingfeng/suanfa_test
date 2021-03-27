package com.leetcode;

import sun.security.util.Length;

public class Test5 {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLen = 1;

        int length = s.length();

        boolean[][] dp = new boolean[length][length];

        for (int right = 1; right < length; right++) {
            if (length - right <= maxLen / 2) {
                break;
            }
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                }
                if (right - left <= 2) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }

                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
//        System.out.println(test5.longestPalindrome("fweaew"));
        System.out.println(test5.longestPalindrome("fweew"));
    }
}
