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

class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] idx = new int[n];
        idx[0] = -1;
        for (int i = 1; i < n; i++) {
            if (books[i] > books[i - 1] + 1) {
                idx[i] = i - 1;
                continue;
            }

            int j = idx[i - 1];
            while (j >= 0 && i - j > books[i] - books[j]) {
                j = idx[j];
            }
            idx[i] = j;
        }
        // System.out.println(Arrays.toString(idx));
        long[] dp = new long[n];
        long ans = books[0];
        dp[0] = books[0];
        for (int i = 1; i < n; i++) {
            int prevIdx = idx[i];
            if (prevIdx >= 0) {
                long prev = ((long)books[i] + books[i] - (i - prevIdx) + 1) * (i - prevIdx) / 2;
                dp[i] = dp[prevIdx] + prev;
            } else {
                long prev = ((long)books[i] + Math.max(1, books[i] - i)) * Math.min(i + 1, books[i]) / 2;
                dp[i] = prev;
            }
            ans = Math.max(ans, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
}
