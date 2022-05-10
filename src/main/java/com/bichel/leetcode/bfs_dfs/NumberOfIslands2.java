package com.bichel.leetcode.bfs_dfs;

/*
You are given an empty 2D binary grid of size m x n.
The grid represents a map where 0's represent water and 1's represent land.
Initially, all the cells of grid are water cells
(i.e., all the cells are 0's).
We may perform an add land operation which turns the water at position
into a land. You are given an array positions where positions[i] = [ri, ci]
is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i]
is the number of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed
by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            List<Integer> overlap = new ArrayList<>();

            if (r - 1 >= 0 && uf.isValid((r - 1) * n + c)) overlap.add((r - 1) * n + c);
            if (r + 1 < m && uf.isValid((r + 1) * n + c)) overlap.add((r + 1) * n + c);
            if (c - 1 >= 0 && uf.isValid(r * n + c - 1)) overlap.add(r * n + c - 1);
            if (c + 1 < n && uf.isValid(r * n + c + 1)) overlap.add(r * n + c + 1);

            int index = r * n + c;
            uf.setParent(index);
            for (int i : overlap)
                uf.union(i, index);
            ans.add(uf.getCount());
        }

        return ans;
    }

    class UnionFind {
        int count; // # of connected components
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) { // for problem 200
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public UnionFind(int N) { // for problem 305 and others
            count = 0;
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = -1;
                rank[i] = 0;
            }
        }

        public boolean isValid(int i) { // for problem 305
            return parent[i] >= 0;
        }

        public void setParent(int i) {
            if (parent[i] != -1) return;

            parent[i] = i;
            ++count;
        }

        public int find(int i) { // path compression
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) { // union with rank
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
