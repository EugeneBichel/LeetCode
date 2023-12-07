package com.bichel.algorithms.popularproblems.islands;

import com.bichel.algorithms.datastructure.Pair;

import java.util.LinkedList;
import java.util.List;

/*
Given an m x n matrix board containing 'X' and 'O',
capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

public class SurroundedRegions {
    private int rows = 0;
    private int cols = 0;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        this.rows = board.length;
        this.cols = board[0].length;

        List<Pair<Integer, Integer>> borders = new LinkedList<>();

        // Step 1). construct the list of border cells
        for (int r = 0; r < rows; r++) {
            borders.add(new Pair<>(r, 0));
            borders.add(new Pair<>(r, this.cols - 1));
        }
        for (int c = 0; c < cols; c++) {
            borders.add(new Pair<>(0, c));
            borders.add(new Pair<>(this.rows - 1, c));
        }

        // Step 2). mark the escaped cells
        for (Pair<Integer, Integer> pair : borders) {
            bfs(board, pair.first, pair.second);
        }

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
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
            if (col < this.cols - 1)
                queue.offer(new Pair<>(row, col + 1));
            if (row < this.rows - 1)
                queue.offer(new Pair<>(row + 1, col));
            if (col > 0)
                queue.offer(new Pair<>(row, col - 1));
            if (row > 0)
                queue.offer(new Pair<>(row - 1, col));
        }
    }
}
