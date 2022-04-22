package com.bichel.other.collections;

import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.peek());
        System.out.println(queue.element());

        //queue.poll()
    }
}
