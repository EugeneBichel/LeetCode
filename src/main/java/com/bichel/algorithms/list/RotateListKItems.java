package com.bichel.algorithms.list;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given the head of a linked list, rotate the list to the right by k places.
 */

public class RotateListKItems {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;

        ListNode tail = head;
        Deque<ListNode> stack = new ArrayDeque<>();

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
        while(cur.next != null && cur.next != head) {
            cur = cur.next;
        }

        cur.next = null;

        return head;
    }
}
