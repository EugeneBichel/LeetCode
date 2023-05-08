package com.bichel.top_interview_questions;

/*
You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 */

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : piles) {
            heap.add(num);
        }

        for (int i = 0; i < k; i++) {
            int curr = heap.remove();
            int remove = curr / 2;
            heap.add(curr - remove);
        }

        int ans = 0;
        for (int num : heap) {
            ans += num;
        }

        return ans;
    }
}
