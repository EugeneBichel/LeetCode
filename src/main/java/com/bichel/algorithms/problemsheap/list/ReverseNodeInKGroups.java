package com.bichel.algorithms.problemsheap.list;

/*
Given a linked list, reverse the nodes of a linked list k at a time and
return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may
be changed.
 */

public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null)
            return null;

        ListNode prev = null;
        ListNode newCur = null;
        ListNode cur = head;
        int counter = 0;

        int size = 0;
        ListNode inc = cur;
        while (inc != null) {
            inc = inc.next;
            size++;
        }

        if (size < k) {
            prev = cur;
            newCur = cur.next;
        } else {
            while (counter < k && cur != null) {

                counter++;

                newCur = cur.next;
                cur.next = prev;
                prev = cur;

                cur = newCur;
            }
        }

        if (newCur != null)
            head.next = reverseKGroup(newCur, k);

        return prev;
    }
}
