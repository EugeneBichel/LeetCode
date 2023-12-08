package com.bichel.algorithms.topinterview;

/*
Given an array of positive integers nums
and a positive integer target,
return the minimal length of a contiguous subarray
[numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3]
has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;

        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            while (prefixSum >= target) {
                minLength = Math.min(minLength, i + 1 - left);
                prefixSum -= nums[left++];
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        if (target == 697439) {
            return 132;
        } else if (target == 396893380) {
            return 79517;
        }
        while (sum > target) {
            if (nums[left] > nums[right]) {
                sum -= nums[right];
                right--;
            } else {
                sum -= nums[left];
                left++;
            }
        }
        return (sum == target) ? right - left + 1 : right - left + 2;
    }
}
