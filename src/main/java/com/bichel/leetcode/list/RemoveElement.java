package com.bichel.leetcode.list;

public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;

        while(cur!= null && cur.val == val ) {
            cur = cur.next;
        }

        head = cur;

        while(cur != null && cur.next != null) {
            if(cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }

        return head;
    }
}
