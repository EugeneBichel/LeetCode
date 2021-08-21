package com.bichel.leetcode.arrays;

import java.util.Arrays;

public class kSmallest {
    public static void main(String[] args) {
        kSmallest program = new kSmallest();

        //[[1,5,9],[10,11,13],[12,13,15]]
        //8
        //int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int[][] a = {{1,2},{1,3}};

        int val = program.kthSmallest(a, 1);
    }

    public int kthSmallest(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows*cols;

        if(size==1) {
            return matrix[0][0];
        }

        int[] a = new int[size];
        int l = 0;

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                a[l++] = matrix[i][j];
            }
        }

        Arrays.sort(a);

        return a[k-1];
    }
}
