package com.bichel.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums, return the maximum length of
a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with
an equal number of 0 and 1.
 */

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int maxlen = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxlen;
    }

    public int findMaxLength2(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];

        Arrays.fill(arr, -2);
        arr[nums.length] = -1;

        int maxlen = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;

            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }

        return maxlen;
    }
}
