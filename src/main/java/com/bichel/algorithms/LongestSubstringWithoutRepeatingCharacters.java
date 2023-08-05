package com.bichel.algorithms;

/*
Given a string s, find the length of the
longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Complexity Analysis
Time complexity : O(2n) = O(n).
In the worst case each character will be visited twice by right and left.

Space complexity : O(min(m, n)).
Same as the previous approach.
We need O(k) space for the sliding window, where k is the size of the Set.
The size of the Set is upper bounded by the size of the string n
and the size of the charset/alphabet m.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int longestLen = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            int subStrLen = right - left + 1;
            longestLen = Math.max(longestLen, subStrLen);

            right++;
        }
        return longestLen;
    }
}
