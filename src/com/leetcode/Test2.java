package com.leetcode;

import com.bean.ListNode;

public class Test2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = a + b + carry;

            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;


            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            cur.next = new ListNode(1);

        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode currentNode = listNode;
        for (int i = 2; i < 6; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }

        ListNode listNode2 = new ListNode(1);
        ListNode currentNode2 = listNode2;
        for (int i = 2; i < 5; i++) {
            currentNode2.next = new ListNode(i);
            currentNode2 = currentNode2.next;
        }

        Test2 test2 = new Test2();
        ListNode result = test2.addTwoNumbers(listNode, listNode2);
        System.out.println("13579");
    }

}
