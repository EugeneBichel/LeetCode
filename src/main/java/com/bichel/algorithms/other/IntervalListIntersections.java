package com.bichel.algorithms.other;

import java.util.List;
import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            int l = Math.max(a[i][0], b[j][0]);
            int h = Math.min(a[i][1], b[j][1]);

            if (l <= h) {
                ans.add(new int[]{l, h});
            }

            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
