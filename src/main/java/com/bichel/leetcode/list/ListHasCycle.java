package com.bichel.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class ListHasCycle {
    public boolean usingFloydCycleFindingAlgorithm(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(true) {
            if (head == null)
                return false;

            if (set.contains(head))
                return true;
            else
                set.add(head);

            head = head.next;
        }
    }
}
