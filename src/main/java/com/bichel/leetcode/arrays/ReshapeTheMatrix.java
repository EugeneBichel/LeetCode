package com.bichel.leetcode.arrays;

/*
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix
into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing
the row number and column number of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix
in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal,
output the new reshaped matrix; Otherwise, output the original matrix.
 */

/*
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 */

public class ReshapeTheMatrix {
    static int[][] matrixReshape(int[][] mat, int r, int c) {
        int oR = mat.length;
        int oC = mat[0].length;

        int amount = oR * oC;

        if(amount != r*c) {
            return mat;
        }

        if(oR == r && oC == c) {
            return mat;
        }

        int[] oldMat = new int[amount];
        int k = 0;
        for(int i = 0; i < oR; i++) {
            for(int j = 0; j < oC; j++) {
                oldMat[k++] = mat[i][j];
            }
        }

        int[][] newMat = new int[r][c];
        k = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                newMat[i][j] = oldMat[k++];
            }
        }

        return newMat;
    }
}
