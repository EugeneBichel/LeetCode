package com.bichel.leetcode.list;

/*
Given the head of a sorted linked list,
delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.
Return the linked list sorted as well.

Time complexity: O(N) since it's one pass along the input list.
Space complexity: O(1) because we don't allocate any additional data structure
 */

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode zero = new ListNode(-1, head);
        ListNode last = zero;
        ListNode first = head;

        while (first != null) {

            if (first.next != null && first.val == first.next.val) {
                while (first.next != null && first.val == first.next.val) {
                    first = first.next;
                }

                last.next = first.next;
            } else {
                last = last.next;
            }

            first = first.next;
        }

        return zero.next;
    }
}
