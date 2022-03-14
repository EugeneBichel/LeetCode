package com.bichel.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */

public class SpiralMatrix {
    class Pair {
        public int col;
        public int row;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (row != pair.row) return false;
            return col == pair.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        final int Nr = matrix.length;
        final int Nc = matrix[0].length;

        int fr = 0, er = Nr - 1;
        int fc = 0, ec = Nc - 1;

        while (fr <= er && fc <= ec) {
            list.addAll(getLevel(matrix, fr, er, fc, ec));
            fr++;
            er--;
            fc++;
            ec--;
        }

        return list;
    }

    private List<Integer> getLevel(int[][] matrix, int fr, int er, int fc, int ec) {

        List<Integer> list = new ArrayList<>();

        if (fr == er && fc == ec)
            list.add(matrix[fr][fc]);
        else {

            Set<Pair> set = new HashSet<>();

            for (int j = fc; j < ec; j++) {

                Pair p = new Pair(fr, j);

                if (!set.contains(p)) {
                    list.add(matrix[fr][j]);
                    set.add(p);
                }
            }

            for (int i = fr; i < er; i++) {

                Pair p = new Pair(i, ec);

                if (!set.contains(p)) {
                    list.add(matrix[i][ec]);
                    set.add(p);
                }
            }

            for (int j = ec; j > fc; j--) {

                Pair p = new Pair(er, j);

                if (!set.contains(p)) {
                    list.add(matrix[er][j]);
                    set.add(p);
                }
            }
            for (int i = er; i > fr; i--) {

                Pair p = new Pair(i, fc);

                if (!set.contains(p)) {
                    list.add(matrix[i][fc]);
                    set.add(p);
                }
            }
        }

        return list;
    }
}
