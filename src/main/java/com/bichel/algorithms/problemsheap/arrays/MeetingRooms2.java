package com.bichel.algorithms.problemsheap.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    private static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        if (intervals.length == 1)
            return 1;

        Arrays.sort(intervals, (int[] l, int[] r) -> Integer.compare(l[0], r[0]));
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (o1, o2) -> o1 - o2);

        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (allocator.peek() < intervals[i][0])
                allocator.poll();

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
