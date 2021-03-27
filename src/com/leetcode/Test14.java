package com.leetcode;

public class Test14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String preFix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String curString = strs[i];

            int end = 0;
            while (true) {
                if (end < preFix.length() && end < curString.length() && preFix.charAt(end) == curString.charAt(end)) {
                    end++;
                } else {
                    break;
                }
            }

            preFix = preFix.substring(0, end);
        }

        return preFix;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
//        String[] strings = new String[]{"flower", "flow"};
        String result = new Test14().longestCommonPrefix(strings);
        System.out.println(result);
    }

}
