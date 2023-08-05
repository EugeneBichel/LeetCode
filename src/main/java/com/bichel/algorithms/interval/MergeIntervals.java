package com.bichel.algorithms.interval;

import java.util.Arrays;
import java.util.LinkedList;

/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the
non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Time complexity : O(nlogn)
Other than the sort invocation, we do a simple linear scan of the list,
so the runtime is dominated by the O(nlogn) complexity of sorting.

Space complexity : (or O(n)O(n))
If we can sort intervals in place, we do not need more than constant additional space,
although the sorting itself takes O(logn) space.
Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(
                        merged.getLast()[1],
                        interval[1]
                );
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
