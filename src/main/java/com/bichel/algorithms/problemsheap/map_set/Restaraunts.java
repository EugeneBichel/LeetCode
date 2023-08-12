package com.bichel.algorithms.problemsheap.map_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Restaraunts {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> m2 = new HashMap<>();
        for(int i=0; i<list2.length; i++) {
            m2.put(list2[i], i);
        }

        Map<String, Integer> m1 = new HashMap<>();
        for(int i=0; i<list1.length; i++) {
            if(m2.containsKey(list1[i]))
                m1.put(list1[i], m2.get(list1[i]) + i);
        }

        int min = Integer.MAX_VALUE;
        List<String> a = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: m1.entrySet()) {
            if(entry.getValue() < min ) min = entry.getValue();
        }

        for(Map.Entry<String, Integer> entry: m1.entrySet()) {
            if(entry.getValue() == min ) a.add(entry.getKey());
        }

        String[] arr = new String[a.size()];
        int ind=0;
        for(String s: a) arr[ind++] = s;

        return arr;
    }
}
