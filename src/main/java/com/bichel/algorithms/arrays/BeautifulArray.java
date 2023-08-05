package com.bichel.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/*
For some fixed n, an array nums is beautiful
if it is a permutation of the integers 1, 2, ..., n, such that:
For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
Given n, return any beautiful array nums.  (It is guaranteed that one exists.)

Example 1:
Input: n = 4
Output: [2,1,4,3]
 */
public class BeautifulArray {
    public int[] beautifulArray(int n) {
        Set<int[]> combination = new HashSet<>();
        for(int i=0; i<n;i++) {

            for(int k=0; k<n; k++) {
                int[] a = new int[n];

                for(int j=1; j<=n; j++) {
                    a[k] = j;
                }

                combination.add(a);
            }
        }

        return null;
    }
}
