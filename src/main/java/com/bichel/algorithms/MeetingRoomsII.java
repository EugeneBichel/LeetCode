package com.bichel.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array of meeting time intervals intervals
where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
 */

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, Comparator.comparingInt((int[] item) -> item[0]));

        Queue<Integer> heap = new PriorityQueue<>(intervals.length,
                (x1, x2) -> x1 - x2);
        heap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (heap.peek() <= intervals[i][0])
                heap.remove();

            heap.add(intervals[i][1]);
        }

        return heap.size();
    }
}
