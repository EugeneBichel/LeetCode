package com.bichel.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
Given a string s, return true if a permutation
of the string could form a palindrome.

Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true

Complexity Analysis

Time complexity : O(n). We traverse over the given string ss with nn characters once.
We also traverse over the map which can grow up to a size of nn in case all characters
in s are distinct.

Space complexity : O(1). The map can grow up to a maximum number of all distinct elements.
However, the number of distinct characters are bounded, so as the space complexity.
 */

public class PalindromePermutation {

    public boolean canPermutePalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }

        if (s.length() % 2 == 0)
            return count == 0;

        return count == 1;
    }

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(m.values());

        if (s.length() % 2 == 0) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) % 2 != 0) return false;
            }
        } else {

            int count = 0;

            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) != 2) count++;

                if (count > 1) return false;
            }
        }

        return true;
    }
}
