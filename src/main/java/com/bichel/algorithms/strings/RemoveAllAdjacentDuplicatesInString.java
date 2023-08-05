package com.bichel.algorithms.strings;

/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and
equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.
It can be proven that the answer is unique.
 */

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
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
}
