package com.offer;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test6 {

    public int[] reversePrint(ListNode head) {
        int number = 0;

        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            number++;
        }

        int[] array = new int[number];


        for (int i = number - 1; i >= 0; i--) {
            array[i] = head.val;
            head = head.next;
        }

        return array;
    }

    public static void main(String[] args) {
        ListNode listNode = DataUtils.getOneToNumberListNode(4);
        int[] result = new Test6().reversePrint(listNode);
        System.out.println(result);
    }
}
