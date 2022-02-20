package com.bichel.classicproblems.interval;

import java.util.Arrays;
import java.util.LinkedList;

/*
Given an array intervals where intervals[i] = [li, ri]
represent the interval [li, ri), remove all intervals that are covered
by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.
 */

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (list.getLast()[0] >= intervals[i][0] && list.getLast()[1] <= intervals[i][1]) {
                list.removeLast();
            } else if (list.getLast()[0] <= intervals[i][0] && list.getLast()[1] >= intervals[i][1]) {
                continue;
            }

            list.add(intervals[i]);
        }

        return list.size();
    }
}
