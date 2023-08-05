package com.bichel.algorithms.list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode better(ListNode headA, ListNode headB) {

        ListNode nA = headA;
        ListNode nB = headB;

        while(nA != nB) {
            nA = nA == null ? headB : nA.next;
            nB = nB == null ? headA : nB.next;
        }

        return nA;

    }

    public ListNode usingHashSet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headB != null) {
            set.add(headB);
            headB = headB.next;
        }

        while(headA != null) {
            if(set.contains(headA)) return headA;
            headA = headA.next;
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        while(headA != null) {

            ListNode curB = headB;
            while(curB != null) {
                if(curB == headA) return curB;
                curB = curB.next;
            }

            headA = headA.next;
        }

        return null;
    }
}
