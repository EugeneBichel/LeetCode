package com.bichel.algorithms.arrays;

/*
Given two integer arrays nums1 and nums2,
return an array of their intersection.
Each element in the result must appear as many times as
it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) return intersect(nums2, nums1);

        Map<Integer, Integer> m = new HashMap<>();
        for(int n: nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        int k=0;
        for(int n: nums2) {
            int count = m.getOrDefault(n, 0);

            if(count > 0) {
                nums1[k++] = n;
                m.put(n, count - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
