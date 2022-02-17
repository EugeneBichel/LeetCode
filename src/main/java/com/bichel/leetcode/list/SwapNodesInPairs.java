package com.bichel.leetcode.list;

/*
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    public ListNode swapPairsIterative(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while (head != null && head.next != null) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        return dummy.next;
    }
}
