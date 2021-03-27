package com.leetcode;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test21_digui {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = DataUtils.getToNumberListNode(1, 2);
        DataUtils.printListNode(listNode1);
        ListNode listNode2 = DataUtils.getToNumberListNode(1, 1);
        DataUtils.printListNode(listNode2);

        Test21_digui test21 = new Test21_digui();
        ListNode list = test21.mergeTwoLists(listNode1, listNode2);
        DataUtils.printListNode(list);
    }

}
