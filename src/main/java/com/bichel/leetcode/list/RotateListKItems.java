package com.bichel.leetcode.list;

import java.util.Stack;

public class RotateListKItems {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        ListNode tail = head;
        Stack<ListNode> stack = new Stack<>();

        while(tail != null) {
            stack.push(tail);
            tail = tail.next;
        }

        k = k % stack.size();

        while(k > 0) {

            ListNode newHead = stack.pop();

            newHead.next = head;
            head = newHead;

            k--;
        }

        ListNode cur = head;
        while(cur.next!= null && cur.next != head) {
            cur = cur.next;
        }

        cur.next = null;

        return head;
    }
}
