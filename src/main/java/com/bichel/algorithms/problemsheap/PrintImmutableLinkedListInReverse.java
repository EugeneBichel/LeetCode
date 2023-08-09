package com.bichel.algorithms.problemsheap;

import com.bichel.algorithms.problemsheap.list.ListNode;

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
