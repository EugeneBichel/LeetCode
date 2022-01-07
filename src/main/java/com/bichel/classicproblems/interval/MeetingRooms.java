package com.bichel.classicproblems.interval;

import java.util.Arrays;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi],
determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
 */

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] == intervals[i-1][0] ||
                    intervals[i][0] < intervals[i-1][1])
                return false;
        }

        return true;
    }
}
