package com.bichel.leetcode.top_interview_questions;

import com.bichel.leetcode.list.ListNode;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.


 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode current = new ListNode(0);
        ListNode result = current;

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
}

