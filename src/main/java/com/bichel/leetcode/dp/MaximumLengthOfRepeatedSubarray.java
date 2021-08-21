package com.bichel.leetcode.dp;

/*
Given two integer arrays nums1 and nums2,
return the maximum length of a subarray that appears in both arrays.

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray pr = new MaximumLengthOfRepeatedSubarray();

        int[] a1= {1,2,3,2,1};
        int[] a2={3,2,1,4,7};

        int maxL = pr.dpUsingMemo(a1, a2);

        System.out.println(maxL);
    }

    private int maxLen = 0;

    private int dpUsingMemo(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];

        for (int i = nums1.length - 1; i >= 0; --i) {
            for (int j = nums2.length - 1; j >= 0; --j) {
                if (nums1[i] == nums2[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    private int withHashMap(int[] nums1, int[] nums2) {
        int maxL = 0;
        Map<Integer, ArrayList<Integer>> Bstarts = new HashMap();

        for (int j = 0; j < nums2.length; j++) {
            Bstarts.computeIfAbsent(nums2[j], x -> new ArrayList()).add(j);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (Bstarts.containsKey(nums1[i])) {
                for (int j : Bstarts.get(nums1[i])) {
                    int k = 0;
                    while (i + k < nums1.length &&
                            j + k < nums2.length &&
                            nums1[i + k] == nums2[j + k]) {
                        k++;
                    }
                    maxL = Math.max(maxL, k);
                }
            }
        }

        return maxL;
    }

    private void bruteForceSolution(int[] nums1, int[] nums2) {
        maxLen = 0;

        for(int i=0; i< nums1.length; i++) {
            for(int j=0; j< nums2.length; j++) {
                int k = 0;
                while(i+k < nums1.length &&
                        j+k < nums2.length && nums1[i+k] == nums2[j+k]) {
                    k++;
                    maxLen = Math.max(maxLen, k);
                }
            }
        }
    }


    /*
    Using binary search
     */
    public int findLengthUsingBinarySearch(int[] A, int[] B) {
        int lo = 0, hi = Math.min(A.length, B.length) + 1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (check(mi, A, B)) lo = mi + 1;
            else hi = mi;
        }
        return lo - 1;
    }
    public boolean check(int length, int[] A, int[] B) {
        Set<String> seen = new HashSet();
        for (int i = 0; i + length <= A.length; ++i) {
            seen.add(Arrays.toString(Arrays.copyOfRange(A, i, i+length)));
        }
        for (int j = 0; j + length <= B.length; ++j) {
            if (seen.contains(Arrays.toString(Arrays.copyOfRange(B, j, j+length)))) {
                return true;
            }
        }
        return false;
    }
}
