package com.bichel.algorithms.unsorted;

/*
Given an integer array nums and an integer k,
return the k most frequent elements.
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //O(1) time
        if (k == nums.length)
            return nums;

        //O(N) time
        Map<Integer, Integer> mCounter = new HashMap<>();
        for (int n : nums) {
            mCounter.put(n, mCounter.getOrDefault(n, 0) + 1);
        }

        //less frequent element firsts
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> mCounter.get(n1) -
                mCounter.get(n2));

        //O(N log k)
        for (int n : mCounter.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] ans = new int[k];

        //O(k log k)
        for (int i = 0; i < k; i++) {
            ans[k - 1 - i] = minHeap.poll();
        }

        return ans;
    }
}
