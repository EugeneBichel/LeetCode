package com.bichel.algorithms;

import com.bichel.algorithms.list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintImmutableLinkedListInReverse {
    public void printLinkedListInReverse(ListNode head) {
        Deque<ListNode> queue = new ArrayDeque<>();
        while(head != null) {
            queue.push(head);
            //head = head.getNext();
        }

        while(!queue.isEmpty()) {
            //queue.pop().printValue();
        }
    }
}
