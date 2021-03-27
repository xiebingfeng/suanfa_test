package com.leetcode;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode();

        ListNode curNode = headNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = l1 != null ? l1 : l2;
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = DataUtils.getOneToNumberListNode(1);
        ListNode listNode2 = DataUtils.getOneToNumberListNode(3);

        Test21 test21 = new Test21();
        ListNode list = test21.mergeTwoLists(listNode1, listNode2);
        DataUtils.printListNode(list);
    }

}
