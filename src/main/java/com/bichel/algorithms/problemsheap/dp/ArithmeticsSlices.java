package com.bichel.algorithms.problemsheap.dp;

/*
An integer array is called arithmetic if it consists of at least three elements and
if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Time complexity : O(n^2). Two for loops are used.
Space complexity : O(1). Constant extra space is used.

 */

public class ArithmeticsSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    //DP
    /*
    Time complexity : O(n).
        We traverse over the given A array with n elements once only.

    Space complexity : O(n). 1-D dp of size n is used.
     */
    public int numberOfArithmeticSlicesDP(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    /*
    Time complexity : O(n).
        We traverse over the given A array with nn elements once only.
    Space complexity : O(1).
        Constant extra space is used.
     */
    public int dpWithConstantExtraSpace(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else
                dp = 0;
        }
        return sum;
    }
}
