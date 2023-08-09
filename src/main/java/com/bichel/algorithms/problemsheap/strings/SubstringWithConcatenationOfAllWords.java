package com.bichel.algorithms.problemsheap.strings;

/*
You are given a string s and an array of strings words of the same length.
Return all starting indices of substring(s) in s that is a concatenation
of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    private Map<String, Integer> wordCount = new HashMap<String, Integer>();
    private int wordLength;
    private int substringSize;
    private int k;

    private boolean check(int i, String s) {
        // Copy the original dictionary to use for this index
        Map<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;

        // Each iteration will check for a match in words
        for (int j = i; j < i + substringSize; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }

        return wordsUsed == k;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                answer.add(i);
            }
        }

        return answer;
    }
}
