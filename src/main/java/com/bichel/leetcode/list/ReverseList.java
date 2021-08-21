package com.bichel.leetcode.list;

public class ReverseList {

    public static void main(String[] args) {

        ReverseList pr = new ReverseList();

        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(2);
        curr.next.next = new ListNode(3);
        curr.next.next.next = new ListNode(4);

        ListNode newHead = pr.reverseList(head);
    }

    private ListNode reverseList(ListNode head) {

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
