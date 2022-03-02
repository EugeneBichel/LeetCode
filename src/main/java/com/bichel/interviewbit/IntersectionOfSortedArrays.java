package com.bichel.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays,
find all the elements which occur in both the arrays.

Example:
Input:
    A: [1 2 3 3 4 5 6]
    B: [3 3 5]
 */

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer val : B)
            map.put(val,
                    map.getOrDefault(val, 0) + 1);

        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                if (map.get(A.get(i)) > 0) {
                    map.put(A.get(i), map.getOrDefault(A.get(i), 0) - 1);
                    ans.add(A.get(i));
                }
            }
        }

        return new ArrayList<Integer>(ans);
    }
}
