package com.bichel.leetcode.arrays;

import java.util.Arrays;

public class MeetingRooms {
    private static boolean canAttendMeetings(int[][] intervals) {

        if (intervals == null || intervals.length == 0)
            return true;

        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0] ||
                    intervals[i][0] < intervals[i - 1][1])
                return false;
        }

        return true;
    }
}
