package com.utils;

import com.bean.ListNode;

import java.util.List;

public class DataUtils {

    public static void printArray(int[] nums) {
        if (null == nums) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
        System.out.println();
    }

    public static void printList(List<List<Integer>> result) {
        if (null == result) {
            return;
        }

        for (int i = 0; i < result.size(); i++) {
            for (int t : result.get(i)) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static ListNode getOneToNumberListNode(int num) {
        ListNode headNode = new ListNode(1);
        ListNode currentNode = headNode;
        for (int i = 2; i < num + 1; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return headNode;
    }

    public static ListNode getToNumberListNode(int first, int num) {
        ListNode headNode = new ListNode(first);
        ListNode currentNode = headNode;
        for (int i = 1; i < num; i++) {
            currentNode.next = new ListNode(first + i);
            currentNode = currentNode.next;
        }
        return headNode;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
