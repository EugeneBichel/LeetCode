package com.bichel.leetcode.list;

/*
Given the head of a singly linked list and two integers
left and right where left <= right, reverse the nodes of
the list from position left to position right, and return the reversed list.

Time Complexity: O(N)
    considering the list consists of NN nodes.
    We process each of the nodes at most once
    (we don't process the nodes after the n^{th}n th  node from the beginning.
Space Complexity: O(1)
    since we simply adjust some pointers in the original linked list
    and only use O(1) additional memory for achieving the final result.
 */

public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
