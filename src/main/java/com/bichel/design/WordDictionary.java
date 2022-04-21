package com.bichel.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordDictionary {
    Map<Integer, Set<String>> d;

    /** Initialize your data structure here. */
    public WordDictionary() {
        d = new HashMap();
    }


    public void addWord(String word) {
        int m = word.length();
        if (!d.containsKey(m)) {
            d.put(m, new HashSet<>());
        }

        d.get(m).add(word);
    }

    public boolean search(String word) {
        int m = word.length();

        if (d.containsKey(m)) {
            for (String w : d.get(m)) {
                int i = 0;
                while ((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == m) return true;
            }
        }

        return false;
    }
}
