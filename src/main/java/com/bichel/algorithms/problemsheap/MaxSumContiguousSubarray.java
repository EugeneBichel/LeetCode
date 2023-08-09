package com.bichel.algorithms.problemsheap;

/*
Find the contiguous subarray within an array,
A of length N which has the largest sum.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the maximum possible sum of the contiguous subarray.
 */

import java.util.List;

public class MaxSumContiguousSubarray {
    // accepted
    public int maxSubArray4(List<Integer> a) {
        int sum = a.get(0);
        int max = a.get(0);

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < a.size(); i++) {
            int num = a.get(i);

            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }

        return max;
    }

    //time limit
    public int maxSubArray(final List<Integer> a) {
        int maxsum = Integer.MIN_VALUE;

        for (int start = 0; start < a.size(); start++) {
            for (int end = start + 1; end <= a.size(); end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += a.get(i);
                }

                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum;
    }

    //time limit exceeded
    public int maxSubArray2(int[] nums) {
        int maxsum = Integer.MIN_VALUE;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                maxsum = Math.max(maxsum, sum[end] - sum[start]);
            }
        }
        return maxsum;
    }

    //time limit exceeded
    public int maxSubArray3(List<Integer> a) {
        int maxsum = Integer.MIN_VALUE;

        for (int start = 0; start < a.size(); start++) {
            int sum = 0;
            for (int end = start; end < a.size(); end++) {
                sum += a.get(end);
                maxsum = Math.max(maxsum, sum);
            }
        }

        return maxsum;
    }
}
