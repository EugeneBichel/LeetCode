package com.bichel.leetcode.amazon.others;

/*
There are 8 prison cells in a row and each cell
is either occupied or vacant.

Each day, whether the cell is occupied or
vacant changes according to the following rules:

If a cell has two adjacent neighbors that
are both occupied or both vacant,
then the cell becomes occupied.
Otherwise, it becomes vacant.
Note that because the prison is a row,
the first and the last cells in
the row can't have two adjacent neighbors.

You are given an integer array cells
where cells[i] == 1 if the ith cell is
occupied and cells[i] == 0 if the ith cell
is vacant, and you are given an integer n.

Return the state of the prison after n days
(i.e., n such changes described above).
 */

import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap<>();
        boolean isFastForwarded = false;

        // step 1). run the simulation with hashmap
        while (N > 0) {
            if (!isFastForwarded) {
                int stateBitmap = this.cellsToBitmap(cells);
                if (seen.containsKey(stateBitmap)) {
                    // the length of the cycle is seen[state_key] - N
                    N %= seen.get(stateBitmap) - N;
                    isFastForwarded = true;
                } else
                    seen.put(stateBitmap, N);
            }
            // check if there is still some steps remained,
            // with or without the fast-forwarding.
            if (N > 0) {
                N -= 1;
                cells = this.nextDay(cells);
            }
        }
        return cells;
    }

    private int cellsToBitmap(int[] cells) {
        int stateBitmap = 0x0;
        for (int cell : cells) {
            stateBitmap <<= 1;
            stateBitmap = (stateBitmap | cell);
        }
        return stateBitmap;
    }

    private int[] nextDay(int[] cells) {
        int[] newCells = new int[cells.length];
        newCells[0] = 0;
        for (int i = 1; i < cells.length - 1; i++)
            newCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        newCells[cells.length - 1] = 0;
        return newCells;
    }
}
