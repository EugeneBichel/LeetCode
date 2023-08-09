package com.bichel.algorithms.problemsheap.heap;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k,
return the kth largest element in the array.
Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Time complexity : O(Nlogk).
Space complexity : O(k) to store the heap elements.
 */

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            minHeap.add(n);

            if (minHeap.size() > k)
                minHeap.poll(); // fetch from the head and remove
        }

        return minHeap.poll();
    }
}
