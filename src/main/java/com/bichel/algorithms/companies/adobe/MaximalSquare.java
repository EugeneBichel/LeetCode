package com.bichel.algorithms.companies.adobe;

/*
Given an m x n binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return its area.

Ex 1:
Input: matrix = [
    ["1","0","1","0","0"],
    ["1","0","1","1","1"],
    ["1","1","1","1","1"],
    ["1","0","0","1","0"]
]
Output: 4

Ex 2:
Input: matrix = [
    ["0","1"],
    ["1","0"]
]
Output: 1
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
