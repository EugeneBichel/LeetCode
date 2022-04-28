package com.bichel.leetcode.dp;

/*
You are given two integers m and n.
Consider an m x n grid where each cell is initially white.
You can paint each cell red, green, or blue.
 All cells must be painted.

Return the number of ways to color the grid with no two adjacent cells having the same color.
Since the answer can be very large, return it modulo 10^9 + 7.

1 <= m <= 5
1 <= n <= 1000
 */

public class PaintingAGridWithThreeDifferentColors {
    public int colorTheGrid(int m, int n) {
        int i = 0, j = 0, cur = 0, prev = 0;
        return color(m, n, i, j, cur, prev);
    }

    private int modulo = 1000_000_007;
    private int[][] dp = new int[1001][1024];

    int color(int m, int n, int i, int j, int cur, int prev) {
        if (i == m)
            return color(m, n, 0, j + 1, 0, cur);
        if (j == n)
            return 1;
        if (i == 0 && dp[j][prev] > 0)
            return dp[j][prev];
        int res = 0, up = i == 0 ? 0 : (cur >> ((i - 1) * 2)) & 3, left = prev >> (i * 2) & 3;
        for (int k = 1; k <= 3; ++k)
            if (k != left && k != up)
                res = (res + color(m, n, i + 1, j, cur + (k << (i * 2)), prev)) % modulo;
        if (i == 0)
            dp[j][prev] = res;
        return res;
    }
}
