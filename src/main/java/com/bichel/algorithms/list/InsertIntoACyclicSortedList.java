package com.bichel.algorithms.list;

/*
Given a Circular Linked List node, which is sorted in ascending order,
write a function to insert a value insertVal into the list such
that it remains a sorted circular list. The given node can be a reference to any single node
in the list and may not necessarily be the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place
to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., the given node is null), you should create
a new single circular list and return the reference to that single node.
Otherwise, you should return the originally given node.
 */

public class InsertIntoACyclicSortedList {
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
