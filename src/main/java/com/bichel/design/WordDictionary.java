package com.bichel.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordDictionary {
    Map<Integer, Set<String>> dict;

    public WordDictionary() {
        dict = new HashMap<>();
    }

    public void addWord(String word) {
        int wordLength = word.length();

        if (!dict.containsKey(wordLength)) {
            dict.put(wordLength, new HashSet<>());
        }

        dict.get(wordLength).add(word);
    }

    public boolean search(String word) {
        int wordLength = word.length();

        if (dict.containsKey(wordLength)) {
            for (String w : dict.get(wordLength)) {
                int i = 0;
                while ((i < wordLength) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == wordLength) {
                    return true;
                }
            }
        }

        return false;
    }
}
