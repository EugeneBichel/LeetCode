package com.bichel.algorithms.list;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given head which is a reference node to a singly-linked list.
The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
 */

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int num = 0;
        int pow = 1;
        while (!stack.isEmpty()) {
            int val = stack.pop();
            num += pow * val;
            pow *= 2;
        }

        return num;
    }
}
