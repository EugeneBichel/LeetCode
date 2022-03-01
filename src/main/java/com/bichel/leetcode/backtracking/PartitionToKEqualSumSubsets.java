package com.bichel.leetcode.backtracking;

/*
Given an integer array nums and an integer k,
return true if it is possible to divide this array into k non-empty subsets
whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into
4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    private boolean backtrack(int[] arr, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // Current subset sum exceeds target sum, no need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When current subset sum reaches target sum then one subset is made.
        // Increment count and reset current subset sum to 0.
        if (currSum == targetSum) {
            return backtrack(arr, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j = 0; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }
    /*
    Time complexity: O(N⋅N!)
    The idea is that for each recursive call,
    we will iterate over NN elements and make another recursive call.
    Assume we picked one element, then we iterate over the array and
    make recursive calls for the next N-1N−1 elements and so on.
    Therefore, in the worst-case scenario, the total number of recursive calls
    will be N!N⋅(N−1)⋅(N−2)⋅...⋅2⋅1=N! and in each recursive call we perform
    an O(N) time operation.
     */
    public boolean canPartitionKSubsets1(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];

        return backtrack(arr, 0, 0, k, targetSum, taken);
    }

    /*
    Optimized backtracking

    Let NN be the number of elements in the array and kk be the number of subsets.
    Time complexity: O(k⋅2^N)

    We are traversing the entire array for each subset (once we are done with one subset,
    for the next subset we are starting again with index 0).
    So for each subset, we are choosing the suitable elements from the array
    Once the first subset is found, we go on to find the second,
    which would take 2^N operations roughly (because some numbers have been marked as visited).
    So T = 2^N + 2^N + 2^N + ... = k*2^N
     */
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, boolean[] taken) {

        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            return backtrack(arr, 0, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }
    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public boolean canPartitionKSubsets2(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];

        return backtrack(arr, 0, 0, 0, k, targetSum, taken);
    }
}
