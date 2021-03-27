package com.offer;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Test25 test25 = new Test25();

        ListNode listNode1 = DataUtils.getOneToNumberListNode(3);
        ListNode listNode2 = DataUtils.getOneToNumberListNode(3);
        ListNode result = test25.mergeTwoLists(listNode1, listNode2);
        DataUtils.printListNode(result);
    }

}
