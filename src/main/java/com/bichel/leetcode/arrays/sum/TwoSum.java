package com.bichel.leetcode.arrays.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        int[] indices = betterSolution(nums, target);

        System.out.println(indices[0] + "; " + indices[1]);
    }

    static int[] betterSolution(int[] nums, int target) {
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

    static int[] doTwoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }

        return indices;
    }
}
