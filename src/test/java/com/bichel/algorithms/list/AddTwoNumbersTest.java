package com.bichel.algorithms.list;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {

    @Test
    public void test1() {
        /*
        Input:
        l1 = [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        l2 = [5,6,4]
Output: [8,9,9,9,0,0,0,1]
         */
        ListNode l1 = new ListNode(1);
        ListNode l1Head = l1;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;
        l1.next = new ListNode(1);

        ListNode l2 = new ListNode(5);
        ListNode l2Head = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);


        AddTwoNumbers pr = new AddTwoNumbers();
        //ListNode res = pr.betterSolution(l1Head, l2Head);
/*
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

 */
    }
}
