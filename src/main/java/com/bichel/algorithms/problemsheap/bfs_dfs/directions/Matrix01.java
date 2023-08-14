package com.bichel.algorithms.problemsheap.bfs_dfs.directions;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    private class Pair {
        public int row;
        public int col;

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

    public int[][] updateMatrix(int[][] mat) {
        bfs(mat);
        return mat;
    }

    private void bfs(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        Pair[] neighbors = new Pair[4];
        neighbors[0] = new Pair(0, 1);
        neighbors[1] = new Pair(1, 0);
        neighbors[2] = new Pair(-1, 0);
        neighbors[3] = new Pair(0, -1);

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (Pair neighbor : neighbors) {
                int row = p.row + neighbor.row;
                int col = p.col + neighbor.col;

                if (row < 0 || col < 0 || row >= rows ||
                        col >= cols ||
                        mat[row][col] <= mat[p.row][p.col] + 1) {
                    continue;
                }

                mat[row][col] = mat[p.row][p.col] + 1;
                q.add(new Pair(row, col));
            }
        }
    }
}
