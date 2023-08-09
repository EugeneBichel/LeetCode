package com.bichel.algorithms.problemsheap.list.medium;

/*
Leetcode 369.

Given a non-negative integer represented as a linked list of digits,
plus one to the integer.

The digits are stored such that the most significant digit is
at the head of the list.

Example 1:
Input: head = [1,2,3]
Output: [1,2,4]
 */

import com.bichel.algorithms.problemsheap.list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode cur = head;
        Deque<ListNode> nodesStack = new ArrayDeque<>();

        while (cur != null) {
            nodesStack.push(cur);
            cur = cur.next;
        }

        int num = 0;
        boolean handledLastNode = false;
        while (!nodesStack.isEmpty()) {
            ListNode node = nodesStack.pop();
            int value = node.val + num;

            if (!handledLastNode) {
                value += 1;
                handledLastNode = true;
            }


            num = value / 10;
            node.val = value % 10;
        }

        if (num != 0) {
            ListNode newHead = new ListNode(num, head);
            return newHead;
        } else {
            return head;
        }
    }
}
