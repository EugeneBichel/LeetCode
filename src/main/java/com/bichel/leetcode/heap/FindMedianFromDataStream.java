package com.bichel.leetcode.heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public FindMedianFromDataStream() {
        minH = new PriorityQueue<Integer>();
        /* By default Java provides min heap.
        For max heap, we need to pass in a appropriate comparator */
        maxH = new PriorityQueue<>(1, (ob1, ob2) -> ob2.compareTo(ob1));
    }

    public void addNum(int num) {
        maxH.add(num);
        minH.add(maxH.poll());

        if(minH.size() > maxH.size()) {
            maxH.add(minH.poll());
        }
    }

    public double findMedian() {
        if(minH.size() == maxH.size())
            return (double) (maxH.peek() + minH.peek()) / 2;
        else
            return (double) maxH.peek();
    }
}
