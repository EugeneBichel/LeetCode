package com.bichel.top_interview_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of
the non-overlapping intervals that cover all the intervals in the input.
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval: intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
