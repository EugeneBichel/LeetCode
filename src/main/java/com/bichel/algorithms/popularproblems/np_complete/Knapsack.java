package com.bichel.algorithms.popularproblems.np_complete;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        /*int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }*/

        int n = w.length;

        int[][] value = new int[n+1][W+1];
        for(int i = 0; i <= n; i++) {
            value[i][0] = 0;
        }
        for(int i = 0; i <= W; i++) {
            value[0][i] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                value[i][j] = value[i-1][j];

                if(w[i-1] <= j) {
                    int val = value[i-1][j - w[i-1]] + w[i-1];
                    if(val > value[i][j]) {
                        value[i][j] = val;
                    }
                }
            }
        }

        return value[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

