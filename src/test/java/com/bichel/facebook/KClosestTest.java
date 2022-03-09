package com.bichel.facebook;

import com.bichel.leetcode.math.KClosest;
import org.junit.jupiter.api.Test;

public class KClosestTest {
    @Test
    public void test1() {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;

        KClosest program = new KClosest();
        int[][] kPoints = program.kClosest(points, k);

        for (int i = 0; i < kPoints.length; i++) {
            System.out.println();
            for (int j = 0; j < kPoints[i].length; j++) {
                System.out.print(kPoints[i][j] + " ");
            }
        }
    }
}
