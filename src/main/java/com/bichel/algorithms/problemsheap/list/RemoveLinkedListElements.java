package com.bichel.algorithms.problemsheap.list;

/*
Given the head of a linked list and an integer val,
remove all the nodes of the linked list that has Node.val == val,
and return the new head.
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1, head);
        ListNode newPrevHead = prev;

        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return newPrevHead.next;
    }
}
