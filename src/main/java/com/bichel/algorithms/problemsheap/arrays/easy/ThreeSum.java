package com.bichel.algorithms.problemsheap.arrays.easy;

/*
Given an array nums of n integers and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have
exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        int minDist = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i=1; i<nums.length; i++) {
            int a = nums[i];

            int l = 0;
            int r = nums.length-1;

            while(l < r) {
                if(l == i) {l++; continue;}
                if(r == i) {r--; continue;}

                int curSum = a + nums[l] + nums[r];
                int curDist = Math.abs(target - curSum);
                if(curDist < minDist) {
                    minDist = curDist;
                    closestSum = curSum;
                }

                if(curSum > target) r--;
                else if(curSum < target) l++;
                else if(curSum == target) return target;
            }
        }

        return closestSum;
    }

    /*
Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]] such that i != j, i != k,
and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
     */
    public List<List<Integer>> threeSumMine(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            int a = nums[i];

            int l=0;
            int r=nums.length-1;

            while(l<r) {
                if(i==l) {l++; continue;}
                if(i==r) {r--; continue;}

                int sum = a + nums[l] + nums[r];

                if(sum == 0) {
                    List<Integer> items = new ArrayList<>();

                    items.add(a); items.add(nums[l]); items.add(nums[r]);
                    Collections.sort(items);
                    l++; r--;

                    set.add(items);
                } else if(sum < 0) l++;
                else if(sum > 0) r--;
            }
        }

        return new ArrayList<>(set);
    }
    public List<List<Integer>> threeSumNoSort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList<>(res);
    }
}
