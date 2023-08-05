package com.bichel.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum == k) count++;

            count += map.getOrDefault(sum-k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
