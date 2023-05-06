package com.bichel.classicproblems.prefixsum;

/*
Given an integer array nums and an integer k,
return the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Example 1:
Input: nums = [1,-1,5,-2,3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;

        //key is prefixSum, value is index
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            /*
            Input: nums = [1,-1,5,-2,3], k = 3
            Output: 4
            Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.

            prefixSum = 1; longestSubarray = 0; indices<1, 0>
            prefixSum = 0; longestSubarray = 0; indices<0, 1>
            prefixSum = 5; longestSubarray = 0; indices<5, 2>
            prefixSum = 3; longestSubarray = 4; indices<3, 4>
            prefixSum = 6; longestSubarray = 4; indices<6, 5>
             */

            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }

            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray;
    }
}
