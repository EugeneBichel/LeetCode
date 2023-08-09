package com.bichel.algorithms.problemsheap.list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode newCurr = curr.next;

            curr.next = prev;
            prev = curr;

            curr = newCurr;
        }

        return prev;
    }
}
