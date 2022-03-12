package com.bichel.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging
the letters of a different word or phrase, typically using
all the original letters exactly once.

Time Complexity: O(NKlogK),
where N is the length of strs, and K is the maximum length of a string in strs.
 The outer loop has complexity O(N) as we iterate through each string.
 Then, we sort each string in O(KlogK) time.

Space Complexity: O(NK), the total information content stored in ans.
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);

            String key = new String(chArr);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
