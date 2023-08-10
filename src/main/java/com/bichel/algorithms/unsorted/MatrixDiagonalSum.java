package com.bichel.algorithms.unsorted;

/*
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal
and all the elements on the secondary diagonal that are not part
of the primary diagonal.
 */

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[n-1-i][i]; // Secondary diagonals are row + column = n-1!
        }

        return n % 2 == 0 ? sum : sum - mat[n/2][n/2]; // if n is a odd number, that mean we have added the center element twice!
    }
}
