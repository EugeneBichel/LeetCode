package com.bichel.algorithms.problemsheap.heap;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream.
Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k
and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns
the element representing the kth largest element in the stream.

Given N as the length of nums and MM as the number of calls to add(),

Time complexity: O(N⋅log(N)+M⋅log(k))
Space complexity: O(N)
 */

public class KthLargestElementInStream {
    private static int k;
    private PriorityQueue<Integer> maxHeap;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        maxHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int num: nums) {
            maxHeap.offer(num);
        }

        while (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }

    public int add(int val) {
        maxHeap.offer(val);

        if (maxHeap.size() > k) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
