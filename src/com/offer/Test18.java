package com.offer;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode headNode = new ListNode(-1);
        headNode.next = head;

        ListNode currentNode = headNode;

        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
        }

        return headNode.next;
    }

    public static void main(String[] args) {
        Test18 test18 = new Test18();

        ListNode listNode = DataUtils.getOneToNumberListNode(3);
        ListNode result = test18.deleteNode(listNode, 3);
        DataUtils.printListNode(result);
    }

}
