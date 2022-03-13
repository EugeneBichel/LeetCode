package com.bichel.interviewbit;
import java.util.List;

/*
Say you have an array, A,
for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit.
You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStocksII {
    public int maxProfit(final List<Integer> a) {
        if (a.isEmpty())
            return 0;

        int minPrice = a.get(0);
        int maxProfit = 0;

        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > minPrice)
                maxProfit += a.get(i) - minPrice;

            minPrice = a.get(i);
        }

        return maxProfit;
    }
}
