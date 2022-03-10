package com.bichel.leetcode.arrays.contiguous_subarray;

import java.util.HashMap;
import java.util.Map;

/*

Given an integer array nums and an integer k,
return true if nums has a continuous subarray of size
at least two whose elements sum up to a multiple of k, or false otherwise.
An integer x is a multiple of k if there exists an integer n
such that x = n * k. 0 is always a multiple of k.

Example 1:
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

Example 2:
Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

Example 3:
Input: nums = [23,2,6,4,7], k = 13
Output: false
*/

/*
a + b) = k*x

a = kx - b
b = kx - a

accum[i] = sum[arr[i:j]]
sum[arr[i:j]] = accum[j] - accum[i]

accum[j] = nj = a*k + b , where a, b divmod(nj, k)
accum[i] = ni = c*k + d , where c, d divmod(ni, k)

nj - ni = (a-c)k + (b-d)

True if b -d = 0 -> b = d

So if the same reminder than we found the sum

 */

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // key is reminder, value is pos
        Map<Integer, Integer> reminderWithPosMap = new HashMap<>();
        reminderWithPosMap.put(0, nums[0] % k);

        int sum = 0;

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;

            Integer posWithTheSameReminder = reminderWithPosMap.get(sum);
            if (posWithTheSameReminder != null && i - posWithTheSameReminder > 1) {
                return true;
            } else {
                reminderWithPosMap.put(sum, i);
            }
        }

        return false;
    }
}
