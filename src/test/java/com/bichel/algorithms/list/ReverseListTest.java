package com.bichel.algorithms.list;

import org.junit.jupiter.api.Test;

public class ReverseListTest {

    @Test
    public void testReverseList() {
        ReverseList pr = new ReverseList();

        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(2);
        curr.next.next = new ListNode(3);
        curr.next.next.next = new ListNode(4);

        ListNode newHead = pr.reverseList(head);
    }
}
