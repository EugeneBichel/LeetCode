package com.bichel.algorithms.problemsheap;

/*
Given an integer rowIndex,
return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriange2 {

    //brute force recursion
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++) {
            row.add(getNum(rowIndex, i));
        }

        return row;
    }

    private int getNum(int row, int col) {
        if(row == 0 || col == 0 || row == col) {
            return 1;
        }

        return getNum(row-1, col-1) + getNum(row-1, col);
    }

    //dynamic programming
    private final class RowCol {
        private int row, col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            int result = (int) (row ^ (row >>> 32));
            return (result << 5) - 1 + (int) (col ^ (col >>> 32)); // 31 * result == (result << 5) - 1
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;

            RowCol rowCol = (RowCol) o;
            return row == rowCol.row && col == rowCol.col;
        }
    }

    private Map<RowCol, Integer> cache = new HashMap<>();

    private int getNum2(int row, int col) {
        RowCol rowCol = new RowCol(row, col);

        if (cache.containsKey(rowCol)) {
            return cache.get(rowCol);
        }

        int computedVal =
                (row == 0 || col == 0 || row == col) ? 1 : getNum(row - 1, col - 1) + getNum(row - 1, col);

        cache.put(rowCol, computedVal);

        return computedVal;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum2(rowIndex, i));
        }

        return ans;
    }

}
