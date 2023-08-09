package com.bichel.algorithms.problemsheap;

/*
Given an m x n matrix, return true if the matrix is Toeplitz.
Otherwise, return false.
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Time Complexity: O(M*N), as defined in the problem statement.
Space Complexity: O(1).
 */

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++)
            for (int c = 1; c < matrix[0].length; c++)
                if (matrix[r - 1][c - 1] != matrix[r][c])
                    return false;
        return true;
    }
}
