package com.bichel.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    class Pair {
        public int r;
        public int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (r != pair.r) return false;
            return c == pair.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }
    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Pair> l = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    l.add(new Pair(i, j));
                }
            }
        }

        for (Pair p : l) {
            for (int i = 0; i < rows; i++)
                matrix[i][p.c] = 0;
            for (int i = 0; i < cols; i++)
                matrix[p.r][i] = 0;
        }
    }
}
