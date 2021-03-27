package com.offer;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode currentNode = head;

        for (int i = 0; i < k; i++) {
            if (null == currentNode) {
                return head;
            }
            currentNode = currentNode.next;
        }

        ListNode resultNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            resultNode = resultNode.next;
        }

        return resultNode;
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();

        ListNode listNode = DataUtils.getOneToNumberListNode(41);
        ListNode result = test22.getKthFromEnd(listNode, 3);
        DataUtils.printListNode(result);
    }

}
