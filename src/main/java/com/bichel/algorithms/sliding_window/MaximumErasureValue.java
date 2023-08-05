package com.bichel.algorithms.sliding_window;

import java.util.HashSet;
import java.util.Set;

/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 */

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int currentSum = 0;
        Set<Integer> set = new HashSet<>();
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            // increment start until subarray has unique elements
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += nums[end];
            set.add(nums[end]);
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }
}
