package com.bichel.algorithms.companies.ibm;

import java.util.PriorityQueue;

public class SortTheStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < m; i++) {
            int s = score[i][k];
            pq.add(new int[]{s, i});
        }

        int[][] newScore = new int[m][n];
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] rem = pq.poll();
            int row = rem[1];

            newScore[idx++] = score[row];
        }

        return newScore;
    }
}
