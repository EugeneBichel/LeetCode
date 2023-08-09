package com.bichel.algorithms.problemsheap.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne {

    interface BinaryMatrix {
        default int get(int row, int col) {
            return 0;
        }

        default List<Integer> dimensions() {
            return new ArrayList<>();
        }
    }

    /*
    Too slow method
     */
    public int leftMostColumnWithOne1(BinaryMatrix bm) {
        int rows = bm.dimensions().get(0);
        int cols = bm.dimensions().get(1);

        int smallestInd = cols;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (bm.get(row, col) == 1) {
                    smallestInd = Math.min(smallestInd, col);
                    break;
                }
            }
        }

        return smallestInd == cols ? -1 : smallestInd;
    }

    /*
    Using binary search
     */
    public int leftMostColumnWithOne2(BinaryMatrix bm) {
        int rows = bm.dimensions().get(0);
        int cols = bm.dimensions().get(1);

        int smallestInd = cols;

        for(int row = 0; row < rows; row++) {
            int lo = 0;
            int hi = cols - 1;

            while(lo < hi) {
                int mid = (lo+hi)/2;
                if(bm.get(row, mid) == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            if(bm.get(row, lo) == 1) {
                smallestInd = Math.min(smallestInd, lo);
            }
        }

        return smallestInd == cols ? -1 : smallestInd;
    }

    /*
    Start at Top Right, Move Left and Bottom
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }
}
