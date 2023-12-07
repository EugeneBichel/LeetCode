package com.bichel.algorithms.companies.amazon;

import java.util.Arrays;
import java.util.Stack;

/*
You are given a 0-indexed integer array books of length n
where books[i] denotes the number of books on the ith shelf
of a bookshelf.

You are going to take books from a contiguous section
of the bookshelf spanning from l to r where 0 <= l <= r < n.
For each index i in the range l <= i < r,
you must take strictly fewer books from shelf i
than shelf i + 1.

Return the maximum number of books you can take
from the bookshelf.
 */
public class MaximumNumberOfBooksYouCanTake {
    public long maximumBooks(int[] books) {
        int n = books.length;

        Stack<Integer> s = new Stack<>();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            // While we cannot push i, we pop from the stack
            while (!s.isEmpty() && books[s.peek()] - s.peek() >= books[i] - i) {
                s.pop();
            }

            // Compute dp[i]
            if (s.isEmpty()) {
                dp[i] = calculateSum(books, 0, i);
            } else {
                int j = s.peek();
                dp[i] = dp[j] + calculateSum(books, j + 1, i);
            }

            // Push the current index onto the stack
            s.push(i);
        }


        // Return the maximum element in dp array
        return Arrays.stream(dp).max().getAsLong();
    }

    // Helper function to calculate the sum of books in a given range [l, r]
    private long calculateSum(int[] books, int l, int r) {
        long cnt = Math.min(books[r], r - l + 1);
        return (2 * books[r] - (cnt - 1)) * cnt / 2;
    }
}
