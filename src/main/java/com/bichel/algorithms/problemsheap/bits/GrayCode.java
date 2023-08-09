package com.bichel.algorithms.problemsheap.bits;

/*
An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        // Keeps track of the numbers present in the current sequence.
        Set<Integer> isPresent = new HashSet<>();
        // All Gray code sequence starts with 0
        isPresent.add(0);
        grayCodeHelper(result, n, isPresent);
        return result;
    }

    private boolean grayCodeHelper(List<Integer> result, int n, Set<Integer> isPresent) {
        if (result.size() == (1 << n)) return true;

        int current = result.get(result.size() - 1);
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (!isPresent.contains(next)) {
                isPresent.add(next);
                result.add(next);
                // If valid sequence found no need to search any further
                if (grayCodeHelper(result, n, isPresent)) return true;
                // If no valid sequence found delete the last added number and continue the search.
                isPresent.remove(next);
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}
