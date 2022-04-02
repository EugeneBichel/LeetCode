package com.bichel.facebook.fbrecruiting;

import java.util.HashMap;
import java.util.Map;

/*
Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
Signature
bool areTheyEqual(int[] arr_a, int[] arr_b)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if B can be made equal to A, return false otherwise.
Example
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
output = true
After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 */

public class ReverseToMakeEqual {
    boolean areTheyEqual(int[] a, int[] b) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        }

        for (int i = 0; i < b.length; i++) {
            m2.put(b[i], m2.getOrDefault(b[i], 0) + 1);
        }

        return m.equals(m2);
    }
}
