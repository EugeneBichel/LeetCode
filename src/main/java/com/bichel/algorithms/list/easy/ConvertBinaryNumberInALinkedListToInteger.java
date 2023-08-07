package com.bichel.algorithms.list.easy;

import com.bichel.algorithms.list.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int decimalValue = head.val;

        while (head.next != null) {
            decimalValue = (decimalValue << 1) | head.next.val;
            head = head.next;
        }

        return decimalValue;
    }
}
