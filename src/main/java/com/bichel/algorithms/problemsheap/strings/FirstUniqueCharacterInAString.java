package com.bichel.algorithms.problemsheap.strings;

/*
Given a string s,
find the first non-repeating character in it
and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
 */

import java.util.Arrays;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MIN_VALUE);
        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i++) {
            if(arr[chars[i] - 'a'] == Integer.MIN_VALUE)
                arr[chars[i] - 'a'] = i;
            else arr[chars[i] - 'a'] = -1;
        }

        int ans = -1;
        for(int i=0; i<arr.length; i++)
            if(arr[i] != -1 && arr[i] != Integer.MIN_VALUE ) {
                if(ans != -1 && arr[i] < ans)
                    ans = arr[i];
                else if(ans == -1) ans = arr[i];
            }

        return ans;
    }
}
