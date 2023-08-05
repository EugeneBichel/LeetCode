package com.bichel.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string array words,
return an array of all characters that show up in
all strings within the words (including duplicates).
You may return the answer in any order.

Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 */

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] chars = new int[26];
        Arrays.fill(chars, Integer.MAX_VALUE);

        List<String> ans = new ArrayList<>();
        int n = words.length;
        for(int j=0; j< n; j++) {
            int[] cur = new int[26];
            Arrays.fill(cur, 0);

            for(Character ch: words[j].toCharArray()) {
                cur[ch-'a'] = cur[ch-'a'] + 1;
            }

            for(int i=0; i<26; i++) {
                chars[i] = Math.min(chars[i], cur[i]);
            }
        }

        List<String> l = new ArrayList<>();
        for(int i=0; i<26; i++) {
            int num = chars[i];
            while(num > 0) {
                l.add(Character.toString(i+'a'));
                num--;
            }
        }

        return l;
    }
}
