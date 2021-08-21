package com.bichel.leetcode.math;

import java.util.Arrays;

public class KClosest {
    public static void main(String[] args) {

        int[][] points = {{1,3},{-2,2}};
        int k = 1;

        KClosest program = new KClosest();
        int[][] kPoints = program.kClosest(points, k);

        for(int i=0;i<kPoints.length;i++) {
            System.out.println();
            for(int j=0;j<kPoints[i].length;j++) {
                System.out.print(kPoints[i][j] + " ");
            }
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, (int[] a, int[] b) -> {
            double d1 = Math.sqrt((a[0]*a[0] + a[1]*a[1]));
            double d2 = Math.sqrt((b[0]*b[0] + b[1]*b[1]));

            return Double.compare(d1, d2);
        });

        int[][] res = new int[k][];
        for(int i=0;i<k;i++) {
            res[i]=points[i];
        }

        return res;
    }
}
