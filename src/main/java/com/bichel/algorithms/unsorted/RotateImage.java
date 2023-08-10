package com.bichel.algorithms.unsorted;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3

void rotate(vector<vector<int> > &matrix) {
    reverse(matrix.begin(), matrix.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
        }
    }

* anticlockwise rotate
* first reverse left to right, then swap the symmetry
* 1 2 3     3 2 1     3 6 9
* 4 5 6  => 6 5 4  => 2 5 8
* 7 8 9     9 8 7     1 4 7

void anti_rotate(vector<vector<int> > &matrix) {
    for (auto vi : matrix)
        reverse(vi.begin(), vi.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
        }
    }
 */

public class RotateImage {

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

    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int lastInd = n - 1;

                int temp = matrix[lastInd - j][i];
                matrix[lastInd - j][i] = matrix[lastInd - i][lastInd - j];
                matrix[lastInd - i][lastInd - j] = matrix[j][lastInd - i];
                matrix[j][lastInd - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[][] matrix = new int[n][];
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
