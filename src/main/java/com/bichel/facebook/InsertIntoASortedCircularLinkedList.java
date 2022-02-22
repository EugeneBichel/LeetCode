package com.bichel.facebook;

import com.bichel.leetcode.list.ListNode;

public class InsertIntoASortedCircularLinkedList {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            ListNode newNode = new ListNode(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                toInsert = true;
            } else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val)
                    toInsert = true;
            }

            if (toInsert) {
                prev.next = new ListNode(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        prev.next = new ListNode(insertVal, curr);
        return head;
    }
}
