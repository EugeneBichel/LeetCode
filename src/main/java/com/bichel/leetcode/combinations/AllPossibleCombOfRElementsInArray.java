package com.bichel.leetcode.combinations;

import java.util.HashSet;
import java.util.Set;

public class AllPossibleCombOfRElementsInArray {
    public Set<int[]> combinations(int n) {
        Set<int[]> combinations = new HashSet<>();

        int[] a = new int[n];
        for (int k = 0; k < n; k++) {
            a[k] = k+1;
        }

        for (int k = 0; k < n; k++) {
            for (int j = 1; j < n; j++) {
                int temp = a[j];
                a[j] = a[k];
                a[k] = temp;

                if (!combinations.contains(a))
                    combinations.add(a);
            }
        }

        return combinations;
    }
}
