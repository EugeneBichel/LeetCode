package com.bichel.algorithms.problemsheap.dynamic_programming;

import java.util.ArrayList;

/*
Given a grid of size m * n, lets assume you are starting at (1,1)
and your goal is to reach (m,n). At any instance,
if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
Now consider if some obstacles are added to the grids.
How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */

public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
        int M = a.size();
        int N = a.get(0).size();

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) dp[i][0] = 0;
        for (int i = 0; i <= N; i++) dp[0][i] = 0;

        dp[1][1] = 1;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (a.get(i - 1).get(j - 1) == 0) {
                    if (i == 1 && j == 1) continue;
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else dp[i][j] = 0;
            }
        }
        return dp[M][N];
    }
}
