package com.bichel.leetcode.list;

import java.math.BigDecimal;

public class AddTwoNumbers {
    public ListNode betterSolution(ListNode l1, ListNode l2) {
        int sum = 0;
        var current = new ListNode(0);
        var result = current;

        while(l1 != null || l2 != null) {

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;

            sum = sum > 9 ? 1 : 0;
        }

        if(sum != 0) {
            current.next = new ListNode(sum);
        }

        return result.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigDecimal val1 = new BigDecimal(0);
        BigDecimal val2 = new BigDecimal(0);

        BigDecimal pos = BigDecimal.ONE;
        while(l1 != null) {
            val1 = val1.add(new BigDecimal(l1.val).multiply(pos));
            pos = pos.multiply(BigDecimal.TEN);

            l1 = l1.next;
        }

        pos = BigDecimal.ONE;
        while(l2 != null) {
            val2 = val2.add(new BigDecimal(l2.val).multiply(pos));
            pos = pos.multiply(BigDecimal.TEN);

            l2 = l2.next;
        }

        BigDecimal res = val1.add(val2);

        ListNode resListNode = new ListNode();
        ListNode resHead = resListNode;

        pos = BigDecimal.TEN;
        while(res.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal num = res.remainder(pos);
            res = (res.subtract(num)).divide(pos);
            resListNode.val = num.intValue();

            if(res.compareTo(BigDecimal.ZERO)> 0) {
                resListNode.next = new ListNode();
                resListNode = resListNode.next;
            }
        }

        return resHead;
    }
}

