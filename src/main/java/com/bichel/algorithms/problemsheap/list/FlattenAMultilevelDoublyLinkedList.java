package com.bichel.algorithms.problemsheap.list;

/*
You are given a doubly linked list, which contains nodes that have a next pointer,
a previous pointer, and an additional child pointer.
 This child pointer may or may not point to a separate doubly linked list,
 also containing these special nodes. These child lists may have one or more children
 of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list
so that all the nodes appear in a single-level, doubly linked list.
Let curr be a node with a child list. The nodes in the child list should appear
after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all
of their child pointers set to null.

Time complexity O(N)
Space complexity O(N)
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenAMultilevelDoublyLinkedList {
    public ListNodeWithChild flatten(ListNodeWithChild head) {
        if (head == null) return head;

        ListNodeWithChild pseudoHead = new ListNodeWithChild(0, null, head, null);
        ListNodeWithChild curr, prev = pseudoHead;

        Deque<ListNodeWithChild> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null)
                stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
}
