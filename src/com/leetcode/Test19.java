package com.leetcode;

import com.bean.ListNode;
import com.utils.DataUtils;


public class Test19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode p = dummyNode;
        ListNode q = dummyNode;

        for (int i = 0; i < n; i++) {
            if (q.next == null) {
                return dummyNode.next;
            }
            q = q.next;
        }

        while (q.next != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        Test19 test19 = new Test19();
        ListNode head = DataUtils.getOneToNumberListNode(3);
        head = test19.removeNthFromEnd(head, 2);

        DataUtils.printListNode(head);
    }

}
