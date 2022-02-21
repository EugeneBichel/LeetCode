package com.bichel.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/*
ou are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
 */

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //reverse vertical
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];

            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        //swap
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.setAll(matrix[i], a.get(i)::get);
        }

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> l = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                l.add(matrix[i][j]);
            }

            a.set(i, l);
        }
    }
}
