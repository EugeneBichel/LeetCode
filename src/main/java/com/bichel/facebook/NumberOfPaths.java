package com.bichel.facebook;

import java.util.Arrays;

/*
You’re testing a new driverless car that is located at the Southwest (bottom-left)
corner of an n×n grid. The car is supposed to get to the opposite, Northeast (top-right),
corner of the grid. Given n, the size of the grid’s axes,
write a function numOfPathsToDest that returns the number of the possible paths
the driverless car can take.
 */

public class NumberOfPaths {
    public int numOfPathsToDest(int n) {
        if (n == 1)
            return 1;

        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        Arrays.fill(prevRow, 1);
        Arrays.fill(currRow, 1);

        for (int j = 1; j < n; j++) {
            for (int i = j; i < n; i++) {
                if (i == j)
                    currRow[i] = prevRow[i];
                else
                    currRow[i] = currRow[i - 1] + prevRow[i];
            }

            prevRow = currRow;
        }

        return currRow[n - 1];
    }

    public int numOfPathsToDest2(int n) {
        int[][] dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, 1);

        for (int j = 1; j < n; j++) {
            for (int i = j; i < n; i++) {
                if (i == j)
                    dp[i][j] = dp[i][j - 1];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][n - 1];
    }
}
