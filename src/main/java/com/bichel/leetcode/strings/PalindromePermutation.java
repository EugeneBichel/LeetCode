package com.bichel.leetcode.strings;

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
 */

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(Character ch: s.toCharArray()) {
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(m.values());

        if(s.length() % 2 == 0) {
            for(int i=0; i<values.size(); i++) {
                if(values.get(i) % 2 != 0) return false;
            }
        } else {

            int count = 0;

            for(int i=0; i<values.size(); i++) {
                if(values.get(i) != 2) count++;

                if(count > 1) return false;
            }
        }

        return true;
    }
}
