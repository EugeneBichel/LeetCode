package com.bichel.algorithms.unsorted;

/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and
equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.
It can be proven that the answer is unique.

Time complexity : O(N), where N is a string length.
Space complexity : O(N−D) where D is a total length for all duplicates.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLen = 0;

        for (Character ch : s.toCharArray()) {
            if (sbLen != 0 && ch == sb.charAt(sbLen - 1)) {
                sb.deleteCharAt(sbLen - 1);
                sbLen -= 1;
            } else {
                sb.append(ch);
                sbLen++;
            }
        }

        return sb.toString();
    }

    public String removeDuplicates1(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == s.charAt(stack.peek())) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(s.charAt(stack.pop()));
        }

        return sb.reverse().toString();
    }
}
