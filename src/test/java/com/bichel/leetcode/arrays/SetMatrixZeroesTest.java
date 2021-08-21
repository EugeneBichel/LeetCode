package com.bichel.leetcode.arrays;

import org.junit.jupiter.api.Test;

public class SetMatrixZeroesTest {
    @Test
    public void testTestCase1() {
        SetMatrixZeroes pr = new SetMatrixZeroes();

        int[][] arr = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        pr.setZeroes(arr);
    }
}
