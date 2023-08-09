package com.bichel.algorithms.problemsheap.arrays;

import java.util.List;
import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] merge(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        if (a.length == 0 || b.length == 0) return new int[0][2];

        List<int[]> c = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i][0] < b[j][0] && a[i][1] >= b[j][0]) {
                    int[] inter = new int[2];
                    inter[0] = b[j][0];
                    inter[1] = Math.min(a[i][1], b[j][1]);
                    c.add(inter);
                } else if (b[j][0] < a[i][0] && b[j][1] >= a[i][0]) {
                    int[] inter = new int[2];
                    inter[0] = a[i][0];
                    inter[1] = Math.min(a[i][1], b[j][1]);
                    c.add(inter);
                } else if (a[i][0] == b[j][0]) {
                    int[] inter = new int[2];
                    inter[0] = a[i][0];
                    inter[1] = Math.min(a[i][1], b[j][1]);
                    c.add(inter);
                }
            }
        }

        int[][] res = new int[c.size()][2];
        for (int k = 0; k < c.size(); k++)
            res[k] = c.get(k);

        return res;
    }
}
