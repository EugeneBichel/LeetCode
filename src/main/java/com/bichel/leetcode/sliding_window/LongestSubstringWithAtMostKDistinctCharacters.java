package com.bichel.leetcode.sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 */

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() < k+1) return s.length();

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int len = k;

        while(right < s.length()) {

            char ch = s.charAt(right);
            map.put(ch, right++);

            if(map.size() == k+1) {
                int ind = Collections.min(map.values());
                map.remove(s.charAt(ind));

                left = ind + 1;
            }


            len = Math.max(len, right - left);
        }

        return len;
    }
}
