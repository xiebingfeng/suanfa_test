package com.offer;

import java.util.Stack;

public class Test31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int k : pushed) {
            stack.push(k);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == pushed.length ;
    }

    public static void main(String[] args) {
        Test31 test31 = new Test31();

        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        boolean result = test31.validateStackSequences(pushed, popped);
        System.out.println(result);
    }

}
