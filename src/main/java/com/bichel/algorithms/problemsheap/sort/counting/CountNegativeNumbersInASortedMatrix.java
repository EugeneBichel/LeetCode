package com.bichel.algorithms.problemsheap.sort.counting;

/*
Given a m x n matrix grid which is sorted in non-increasing order
both row-wise and column-wise, return the number of negative numbers in grid.
 */

public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int counter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows * cols; i++) {

            int row = i / cols;
            int col = i == 0 ? 0 : i % cols;

            if (grid[row][col] < 0)
                counter++;
        }

        return counter;
    }
}
