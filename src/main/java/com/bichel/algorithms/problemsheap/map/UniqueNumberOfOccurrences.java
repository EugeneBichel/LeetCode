package com.bichel.algorithms.problemsheap.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int keysNum = map.keySet().size();
        int valuesNum = new HashSet<>(map.values()).size();

        return keysNum == valuesNum;
    }
}
