package com.bichel.interviewbit;
import java.util.List;

/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction
(i.e, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Return the maximum possible profit.
 */

public class BestTimeToBuyAndSellStocksI {
    public int maxProfit(final List<Integer> a) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < minPrice)
                minPrice = a.get(i);
            else if (a.get(i) - minPrice > maxProfit)
                maxProfit = a.get(i) - minPrice;
        }

        return maxProfit;
    }
}
