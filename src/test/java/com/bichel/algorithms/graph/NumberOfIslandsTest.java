package com.bichel.algorithms.graph;

import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {
    @Test
    public void test1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumberOfIslands pr = new NumberOfIslands();

        System.out.println(pr.numIslands(grid));
    }
}
