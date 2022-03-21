package com.bichel.leetcode.strings;

/*
You are given a string s. We want to partition the string into as many parts as possible
so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order,
the resultant string should be s.

Return a list of integers representing the size of these parts.

Time Complexity: O(N), where N is the length of S.
Space Complexity: O(1) to keep data structure last of not more than 26 characters.
 */

import java.util.List;
import java.util.ArrayList;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        //alphabet length
        int[] last = new int[26];

        //keep index, where char occurs last
        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        int startPart = 0;
        int endPart = 0;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            endPart = Math.max(endPart, last[s.charAt(i) - 'a']);
            if (i == endPart) {
                int partSize = (endPart - startPart) + 1;
                ans.add(partSize);
                startPart = i + 1;
            }
        }

        return ans;
    }
}
