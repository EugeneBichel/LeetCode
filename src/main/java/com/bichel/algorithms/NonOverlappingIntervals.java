package com.bichel.algorithms;

/*
Given a collection of intervals, we need
to find the minimum number of intervals to be removed
to make the rest of the intervals non-overlapping.
 */

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[1]));

        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
