package com.bichel.algorithms.topinterview;

/*
Given a string s, find the length of the longest substring
without repeating characters.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Input: s = ""
Output: 0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    private static int betterSol(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int currInd = 0, lenOfBeforeRepeated = 0; currInd < n; currInd++) {
            if (map.containsKey(s.charAt(currInd))) {
                lenOfBeforeRepeated = Math.max(map.get(s.charAt(currInd)), lenOfBeforeRepeated);
            }

            int currLength = currInd + 1 - lenOfBeforeRepeated;
            maxLength = Math.max(maxLength, currLength);
            map.put(s.charAt(currInd), currInd + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int longestLen = 0;

        while(right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while(chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            int newSubstrLen = right - left + 1;
            longestLen = Math.max(longestLen, newSubstrLen);

            right++;
        }

        return longestLen;
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> letters = new HashMap<>();
        char[] c = s.toCharArray();
        letters.put(c[0], 0);
        int max = 1;

        for (int i = 1; i < c.length; i++) {
            if (!letters.containsKey(c[i])) {
                letters.put(c[i], i);
                max = Math.max(max, letters.size());
            } else {
                int index = letters.get(c[i]);
                List<Integer> iToRemove = new ArrayList<>();
                for (int ind : letters.values()) {
                    if (ind <= index) {
                        iToRemove.add(ind);
                    }
                }

                for (int ind : iToRemove) {
                    letters.remove(c[ind]);
                }

                letters.put(c[i], i);
            }
        }

        return max;
    }
}
