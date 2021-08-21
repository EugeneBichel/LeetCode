package com.bichel.leetcode.bfs_dfs;

import org.junit.jupiter.api.Test;

public class Matrix01Test {

    @Test
    public void testTestCase1() {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};

        Matrix01 pr = new Matrix01();

        pr.updateMatrix(mat);

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testTestCase2() {
        int[][] mat = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};

        Matrix01 pr = new Matrix01();

        pr.updateMatrix(mat);

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testTestCase3() {
        int[][] mat =
                {
                        {1,0,1,1,0,0,1,0,0,1},
                        {0,1,1,0,1,0,1,0,1,1},
                        {0,0,1,0,1,0,0,1,0,0},
                        {1,0,1,0,1,1,1,1,1,1},
                        {0,1,0,1,1,0,0,0,0,1},
                        {0,0,1,0,1,1,1,0,1,0},
                        {0,1,0,1,0,1,0,0,1,1},
                        {1,0,0,0,1,1,1,1,0,1},
                        {1,1,1,1,1,1,1,0,1,0},
                        {1,1,1,1,0,1,0,0,1,1}
                };

        Matrix01 pr = new Matrix01();
        pr.updateMatrix(mat);

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
