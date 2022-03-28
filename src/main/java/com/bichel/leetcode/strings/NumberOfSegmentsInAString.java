package com.bichel.leetcode.strings;

/*
Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.
 */

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        String[] segments = s.split(" ");
        int counter = 0;
        for (String str : segments) {
            if (!str.isBlank()) counter++;
        }

        return counter;
    }
}
