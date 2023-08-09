package com.bichel.algorithms.problemsheap.arrays;

/*
A school is trying to take an annual photo of all the students.
 The students are asked to stand in a single file line in non-decreasing order by height.
 Let this ordering be represented by the integer array expected where expected[i]
  is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the
students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].
 */

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] alphabet = new int[101];

        for (int i = 0; i < heights.length; i++) {
            alphabet[heights[i]]++;
        }

        int[] sorted = new int[heights.length];
        int j = 0;
        for (int i = 1; i < alphabet.length; i++) {
            while (alphabet[i] != 0) {
                sorted[j++] = i;
                alphabet[i]--;
            }
        }

        int swaps = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i])
                swaps++;
        }

        return swaps;
    }
}
