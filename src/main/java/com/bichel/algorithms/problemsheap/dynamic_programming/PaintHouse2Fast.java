package com.bichel.algorithms.problemsheap.dynamic_programming;

/*
There are a row of n houses, each house can be painted
with one of the k colors. The cost of painting each house
with a certain color is different. You have to paint all the houses
such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented
by an n x k cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with color 0;
costs[1][2] is the cost of painting house 1 with color 2, and so on...
Return the minimum cost to paint all houses.
 */

public class PaintHouse2Fast {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        if(k == 1) return (n==1? costs[0][0] : -1);

        int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
        for(int i = 0; i<n; i++) {
            int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
            for(int j = 0; j<k;  j++) {
                int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
                if(minInd< 0) {min = val; minInd = j;}//when min isn't initialized
                else if(val < min) {//when val < min,
                    secMin = min;
                    min = val;
                    minInd = j;
                } else if(val < secMin) { //when min<=val< secMin
                    secMin = val;
                }
            }
            prevMin = min;
            prevMinInd = minInd;
            prevSecMin = secMin;
        }
        return prevMin;
    }
}
