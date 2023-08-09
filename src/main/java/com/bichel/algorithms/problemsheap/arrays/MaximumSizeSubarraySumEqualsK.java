package com.bichel.algorithms.problemsheap.arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k,
return the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Example 1:
Input: nums = [1,-1,5,-2,3], k = 3
Output: 4

Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 */

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;

        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray,
                        i - indices.get(prefixSum - k));
            } else {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray;
    }
}
