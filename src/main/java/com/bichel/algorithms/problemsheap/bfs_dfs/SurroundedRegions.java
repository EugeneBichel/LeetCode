package com.bichel.algorithms.problemsheap.bfs_dfs;

import java.util.LinkedList;
import java.util.List;

/*
Given an m x n matrix board containing 'X' and 'O',
capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class SurroundedRegions {
    private Integer ROWS = 0;
    private Integer COLS = 0;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<Pair<Integer, Integer>> borders = new LinkedList<>();

        // Step 1). construct the list of border cells
        for (int r = 0; r < this.ROWS; ++r) {
            borders.add(new Pair<>(r, 0));
            borders.add(new Pair<>(r, this.COLS - 1));
        }
        for (int c = 0; c < this.COLS; ++c) {
            borders.add(new Pair<>(0, c));
            borders.add(new Pair<>(this.ROWS - 1, c));
        }

        // Step 2). mark the escaped cells
        for (Pair<Integer, Integer> pair : borders) {
            bfs(board, pair.first, pair.second);
        }

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'E')
                    board[r][c] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int r, int c) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(r, c));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.pollFirst();
            int row = pair.first, col = pair.second;
            if (board[row][col] != 'O')
                continue;

            board[row][col] = 'E';
            if (col < this.COLS - 1)
                queue.offer(new Pair<>(row, col + 1));
            if (row < this.ROWS - 1)
                queue.offer(new Pair<>(row + 1, col));
            if (col > 0)
                queue.offer(new Pair<>(row, col - 1));
            if (row > 0)
                queue.offer(new Pair<>(row - 1, col));
        }
    }
}
