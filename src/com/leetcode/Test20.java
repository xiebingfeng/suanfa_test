package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Test20 {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (charMap.containsKey(curChar)) {
                if (stack.isEmpty() || stack.peek() != charMap.get(curChar)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(curChar);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        System.out.println(test20.isValid("()[)"));
    }

}
