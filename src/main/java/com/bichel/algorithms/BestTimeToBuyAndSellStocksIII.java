package com.bichel.algorithms;
import java.util.List;

/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
Return the maximum possible profit.
Note: You may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStocksIII {
    public int maxProfit(final List<Integer> a) {
        int length = a.size();
        if (length <= 1) return 0;

        int leftMin = a.get(0);
        int rightMax = a.get(length - 1);

        int[] leftProfits = new int[length];
        int[] rightProfits = new int[length + 1];

        for (int l = 1; l < length; l++) {
            leftProfits[l] = Math.max(leftProfits[l - 1], a.get(l) - leftMin);
            leftMin = Math.min(leftMin, a.get(l));

            int r = length - 1 - l;
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - a.get(r));
            rightMax = Math.max(rightMax, a.get(r));
        }

        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }

        return maxProfit;
    }
}
