package com.bichel.spotify;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] getIndices(int[] nums, int target) {
        // x + y = target
        // y = target - x

        int[] indices = new int[2];

        Map<Integer, Integer> mNums = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            mNums.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(mNums.containsKey(target - nums[i]) && mNums.get(target - nums[i]) != i) {
                indices[0] = i;
                indices[1] = mNums.get(target - nums[i]);
                break;
            }
        }

        return indices;
    }
}
