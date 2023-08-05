package com.bichel.algorithms.map;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        Map<Character, String> m = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (m.containsKey(pattern.charAt(i))) {
                if (!words[i].equals(m.get(pattern.charAt(i))))
                    return false;

            } else {
                if (m.containsValue(words[i])) return false;

                m.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }
}
