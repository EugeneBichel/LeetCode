package com.bichel.algorithms.problemsheap.strings;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s1, String s2) {

        Map<Character, Character> map = new HashMap<>();
        //Arrays.f
        char[] c1 = s1.toCharArray();

        for(int i=0; i<c1.length; i++) {

            if(map.isEmpty()) {
                map.put(c1[i], s2.charAt(i));
            } else if(map.containsKey(c1[i])) {
                char val = map.get(c1[i]);
                if(val != s2.charAt(i)) return false;
            } else if(!map.containsKey(c1[i]) && map.containsValue(s2.charAt(i))) {
                return false;
            } else if(!map.containsKey(c1[i]) && !map.containsValue(s2.charAt(i))) {
                map.put(c1[i], s2.charAt(i));
            }
        }

        return true;
    }
}
