package com.bichel.netflix.findmedianage;

import java.util.*;

class MedianOfAges {

    PriorityQueue<Integer> maxHeap; //containing first half of numbers
    PriorityQueue<Integer> minHeap; //containing second half of numbers

    public MedianOfAges() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        // Driver code

        MedianOfAges MedianOfAges = new MedianOfAges();
        MedianOfAges.insertNum(22);
        MedianOfAges.insertNum(35);
        System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
        MedianOfAges.insertNum(30);
        System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
        MedianOfAges.insertNum(25);
        System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
    }
}
