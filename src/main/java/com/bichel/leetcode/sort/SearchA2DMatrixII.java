package com.bichel.leetcode.sort;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Time complexity : O(n+m)
Space complexity : O(1)
 */

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = 0;

        int l = 0;
        int r = rows - 1;

        while (l <= r) {

            int pivot = l + (r - l) / 2;

            if (target >= matrix[pivot][0] && target <= matrix[pivot][cols - 1]) {
                row = pivot;
                break;
            } else if (matrix[pivot][0] < target) l = pivot + 1;
            else if (matrix[pivot][cols - 1] > target) r = pivot - 1;
        }

        l = 0;
        r = cols - 1;

        while (l <= r) {
            int pivot = l + (r - l) / 2;

            if (target == matrix[row][pivot]) return true;
            else if (matrix[row][pivot] > target) r = pivot - 1;
            else l = pivot + 1;
        }

        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }

    //other solution using divide and conque
    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }
    public boolean searchMatrix2(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
}
