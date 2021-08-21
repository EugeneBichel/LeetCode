package com.bichel.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

class SparseVector {
    private Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            if(nums[i] != 0)
                map.put(i, nums[i]);
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        int product = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(vec.containsIndex(entry.getKey()))
                product += entry.getValue() * vec.getValue(entry.getKey());
        }

        return product;
    }

    public boolean containsIndex(int key) {
        return this.map.containsKey(key);
    }

    public int getValue(int key) {
        return map.get(key);
    }
}
