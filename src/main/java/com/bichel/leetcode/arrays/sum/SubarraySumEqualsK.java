package com.bichel.leetcode.arrays.sum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        //how many times each number was seen
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // situation 1:
            // continuous subarray starts
            // from the beginning of the array
            if(sum == k) count++;

            // situation 2:
            // number of times the curr_sum − k has occured already,
            // determines the number of times a subarray with sum k
            // has occured upto the current index
            count += map.getOrDefault(sum-k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
