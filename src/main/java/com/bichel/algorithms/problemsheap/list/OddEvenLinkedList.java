package com.bichel.algorithms.problemsheap.list;

/*
iven the head of a singly linked list, group all the nodes with odd indices together followed
 by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups
should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode prevOdd = new ListNode();
        ListNode newPrev = prevOdd;
        ListNode prevEven = new ListNode();
        ListNode evenHead = prevEven;

        int index = 1;

        while (head != null) {
            if (index % 2 == 1) {
                prevOdd.next = new ListNode(head.val);
                prevOdd = prevOdd.next;
            } else {
                prevEven.next = new ListNode(head.val);
                prevEven = prevEven.next;
            }

            index++;
            head = head.next;
        }

        prevOdd.next = evenHead.next;
        return newPrev.next;
    }
}
