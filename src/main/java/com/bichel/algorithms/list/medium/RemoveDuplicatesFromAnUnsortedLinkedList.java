package com.bichel.algorithms.list.medium;

import com.bichel.algorithms.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromAnUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();

        ListNode curr = head;

        while (curr != null) {
            if (!map.containsKey(curr.val)) {
                map.put(curr.val, 1);
            } else {
                map.put(curr.val, map.get(curr.val) + 1);
            }

            curr = curr.next;
        }

        ListNode stub = new ListNode(-1);
        ListNode currResList = stub;

        curr = head;
        while (curr != null) {
            if (map.get(curr.val) == 1) {
                ListNode n = new ListNode(curr.val);
                currResList.next = n;
                currResList = n;
            }

            curr = curr.next;
        }

        return stub.next;
    }
}
