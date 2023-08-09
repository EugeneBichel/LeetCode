package com.bichel.algorithms.problemsheap.set;

/*
Given an array arr of integers,
check if there exists two integers N and M such
that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 */

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(2 * arr[i]) ||
                    (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) ||
                    (set.contains(arr[i]) && arr[i] == 0))
                return true;

            set.add(arr[i]);
        }

        return false;
    }
}
