package com.bichel.algorithms.strings;

/*
Given a string s and an integer k, return the length of the longest substring of s
such that the frequency of each character in this substring is greater than or equal to k.

Example 1:
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }

    private int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k) return 0;

        int[] countMap = new int[26];

        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;

        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k)
                continue;

            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k)
                midNext++;

            return Math.max(longestSubstringUtil(s, start, mid, k),
                    longestSubstringUtil(s, midNext, end, k));
        }

        return end - start;
    }
}
