package com.offer;

import com.bean.ListNode;
import com.utils.DataUtils;

public class Test24 {

//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;

            cur.next = pre;
            pre = cur;

            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();

        ListNode listNode = DataUtils.getOneToNumberListNode(3);
        ListNode result = test24.reverseList(listNode);
        DataUtils.printListNode(result);
    }

}
