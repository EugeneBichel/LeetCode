package com.bichel.algorithms.problemsheap.heap;

import java.util.PriorityQueue;

/*
You have some number of sticks with positive integer lengths.
These lengths are given as an array sticks,
where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y.
You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Time complexity : O(NlogN), where N is the length of the input array
Space complexity : O(N) since we will store N elements in our priority queue.
 */

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        int totalCost = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.add(stick);
        }

        //combine two of the smallest sticks until we are left with
        //just one
        while (minHeap.size() > 1) {
            int stick1 = minHeap.poll();
            int stick2 = minHeap.poll();

            int cost = stick1 + stick2;

            totalCost += cost;

            minHeap.add(cost);
        }

        return totalCost;
    }
}
