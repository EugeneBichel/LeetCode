package com.bichel.leetcode.arrays.sum;


import java.util.HashMap;
import java.util.Map;

/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

 */
public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int a : A)
            for (int b : B)
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);
        for (int c : C)
            for (int d : D)
                cnt += m.getOrDefault(-(c + d), 0);
        return cnt;
    }
}
