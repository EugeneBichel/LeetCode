package com.bichel.algorithms.problemsheap.arrays;

/*
Given two sparse matrices mat1 of size m x k and mat2 of size k x n,
return the result of mat1 x mat2.
You may assume that multiplication is always possible.
 */

import com.bichel.algorithms.unsorted.Pair;
import java.util.List;
import java.util.ArrayList;

public class SparseMatrixMultiplication {
    private List<List<Pair<Integer, Integer>>> compressMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<List<Pair<Integer, Integer>>> compressedMatrix = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            List<Pair<Integer, Integer>> currRow = new ArrayList<>();

            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != 0) {
                    currRow.add(new Pair<>(matrix[row][col], col));
                }
            }

            compressedMatrix.add(currRow);
        }

        return compressedMatrix;
    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        // Store the non-zero values of each matrix.
        List<List<Pair<Integer, Integer>>> A = compressMatrix(mat1);
        List<List<Pair<Integer, Integer>>> B = compressMatrix(mat2);

        int[][] ans = new int[m][n];

        for (int mat1Row = 0; mat1Row < m; mat1Row++) {
            // Iterate on all current 'row' non-zero elements of mat1.
            for (Pair<Integer, Integer> mat1Element : A.get(mat1Row)) {
                int element1 = mat1Element.getKey();
                int mat1Col = mat1Element.getValue();

                // Multiply and add all non-zero elements of mat2
                // where the row is equal to col of current element of mat1.
                for (Pair<Integer, Integer> mat2Element : B.get(mat1Col)) {
                    int element2 = mat2Element.getKey();
                    int mat2Col = mat2Element.getValue();
                    ans[mat1Row][mat2Col] += element1 * element2;
                }
            }
        }

        return ans;
    }
}
