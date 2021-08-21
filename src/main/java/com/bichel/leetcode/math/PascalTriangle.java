package com.bichel.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> betterSolution(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    private static List<List<Integer>> mySolution(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            triangle.add(row);
            return triangle;
        } else if(numRows > 1 ) {
            List<Integer> row1 = new ArrayList<>();
            row1.add(1);
            triangle.add(row1);

            List<Integer> row2 = new ArrayList<>();
            row2.add(1);row2.add(1);
            triangle.add(row2);
        }

        int[][] dp = new int[numRows][numRows];
        for(int[] arr: dp) {
            Arrays.fill(arr, 1);
        }

        for(int i=2; i<numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for(int j=1; j<i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }

            for(int j=0; j<=i; j++) {
                row.add(dp[i][j]);
            }

            triangle.add(row);
        }

        return triangle;
    }
}
