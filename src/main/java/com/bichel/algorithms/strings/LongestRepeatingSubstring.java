package com.bichel.algorithms.strings;

/*
Given a string s,
find out the length of the longest repeating substring(s).
Return 0 if no repeating substring exists.

Example 1:
Input: s = "abcd"
Output: 0
Explanation: There is no repeating substring.

Example 2:
Input: s = "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba",
each of which occurs twice.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();

        int l = 1;
        int r = n;

        while (l <= r) {
            int pivot = l + (r - l) / 2;

            if (search(pivot, n, s)) l = pivot + 1;
            else r = pivot - 1;
        }

        return l - 1;
    }

    private boolean search(int len, int n, String s) {
        Set<String> seen = new HashSet<>();
        String temp;

        for (int start = 0; start < n - len + 1; start++) {
            temp = s.substring(start, start + len);

            if (seen.contains(temp)) return true;

            seen.add(temp);
        }

        return false;
    }
}
