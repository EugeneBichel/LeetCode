package com.bichel.algorithms;

/*
Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.


 */

import java.util.List;

public class RotatedArray {
    public int findMin(final List<Integer> a) {
        int min = Integer.MAX_VALUE;
        for (int val : a) {
            min = Math.min(min, val);
        }

        return min;
    }
}
