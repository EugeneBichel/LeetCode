package com.bichel.leetcode.dp;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
}
