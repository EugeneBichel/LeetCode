package com.bichel.algorithms.problemsheap.heap;

import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest
two stones and smash them together. Suppose the heaviest two stones have weights x and y
with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.

Time complexity : O(NlogN)
Space complexity : O(N) or O(logN)
 */

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int minWeight = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length,
                (stone1, stone2) -> Integer.compare(stone2, stone1));

        for(int stone: stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if(stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
