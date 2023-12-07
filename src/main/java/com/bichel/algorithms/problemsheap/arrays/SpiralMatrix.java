package com.bichel.algorithms.problemsheap.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

-100 <= matrix[i][j] <= 100
Note that elements in the matrix are constrained to -100 <= matrix[row][col] <= 100,
therefore we can select a number that is out of this range to mark it.
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int visited = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;

        /*
        Given that we are at (row, col),
        where row is the row index,
        and col is the column index.

        move right: (row, col + 1)
        move downwards: (row + 1, col)
        move left: (row, col - 1)
        move upwards: (row - 1, col)
         */
        // Four directions that we will move: right, down, left, up.
        int[][] directions = {
                //r, c
                {0, 1},//right
                {1, 0},//up
                {0, -1},//left
                {-1, 0}//down
        };

        // Initial direction: moving right.
        int currDir = 0;

        // The number of times we change the direction.
        int changeDir = 0;

        // Current place that we are at is (row, col).
        // row is the row index; col is the column index.
        int row = 0;
        int col = 0;

        // Store the first element and mark it as visited.
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = visited;

        while (changeDir < 2) {
            while (row + directions[currDir][0] >= 0 &&
                    row + directions[currDir][0] < rows &&
                    col + directions[currDir][1] >= 0 &&
                    col + directions[currDir][1] < columns &&
                    matrix[row + directions[currDir][0]]
                            [col + directions[currDir][1]] != visited) {
                // Reset this to 0 since we did not break and change the direction.
                changeDir = 0;

                // Calculate the next place that we will move to.
                row = row + directions[currDir][0];
                col = col + directions[currDir][1];

                result.add(matrix[row][col]);
                matrix[row][col] = visited;
            }

            // Change our direction.
            currDir = (currDir + 1) % 4;

            // Increment changeDir because we changed our direction.
            changeDir++;
        }

        return result;
    }
}
