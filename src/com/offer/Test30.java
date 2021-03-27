package com.offer;

import java.util.Stack;

public class Test30 {

    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (stack.size() == 0) {
            stack.push(x);
        } else {
            stack.set(0, Math.min(stack.get(0), x));
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return 0;
        }
    }

    public int min() {
        return stack.get(0);
    }

    public void show() {
        System.out.println(stack);
    }

    public static void main(String[] args) {
        Test30 test30 = new Test30();
//        test30.push(4);
//        test30.push(2);
//        test30.push(3);
//        test30.push(2);
        System.out.println(test30.top());
        System.out.println(test30.top());
        System.out.println(test30.top());
        System.out.println(test30.top());
        System.out.println(test30.top());
        test30.show();
    }
}
