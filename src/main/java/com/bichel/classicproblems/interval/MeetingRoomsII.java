package com.bichel.classicproblems.interval;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, (int[] l, int[] r) -> Integer.compare(l[0], r[0]));

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, (o1, o2) -> o1 - o2);

        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (allocator.peek() <= intervals[i][0])
                allocator.poll();

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
