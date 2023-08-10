package com.bichel.algorithms.unsorted;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
You are given an array and you need to find number of tripets of indices
such that the elements at those indices are in geometric progression
for a given common ratio  and .

Example
There are  and  at indices  and . Return .
 */

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        long counter = 0;

        Map<Long, Long> pairs = new HashMap<>();
        Map<Long, Long> triples = new HashMap<>();

        for (Long val : arr) {
            counter += triples.getOrDefault(val, 0l);

            triples.put(val * r,
                    triples.getOrDefault(val * r, 0l) +
                            pairs.getOrDefault(val, 0l));

            pairs.put(val * r,
                    pairs.getOrDefault(val * r, 0l) +
                            1l);
        }

        return counter;
    }
}
