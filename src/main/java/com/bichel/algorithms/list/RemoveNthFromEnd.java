package com.bichel.algorithms.list;

import java.util.Stack;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> s = new Stack<>();

        ListNode cur = head;

        while(cur != null) {
            s.push(cur);
            cur = cur.next;
        }

        ListNode prev = null;
        int ind = 0;
        while(ind <= n && !s.isEmpty()) {
            prev = s.pop();
            ind++;
        }

        if(prev == head && ind == n) head = head.next;
        else if(prev.next != null)
            prev.next=prev.next.next;

        return head;
    }
}
