package com.bichel.algorithms.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/*
Given four integer arrays nums1, nums2, nums3, and nums4
all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
// 4Sum 2
public class FourSum2 {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        int cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int item1 : a) {
            for (int item2 : b) {
                m.put(item1 + item2,
                        m.getOrDefault(item1 + item2,
                                0) + 1);
            }
        }

        for (int item3 : c) {
            for (int item4 : d) {
                cnt += m.getOrDefault(-(item3 + item4), 0);
            }
        }

        return cnt;
    }
}
