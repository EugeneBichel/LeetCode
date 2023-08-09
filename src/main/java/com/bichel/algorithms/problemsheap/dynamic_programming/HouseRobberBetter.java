package com.bichel.algorithms.problemsheap.dynamic_programming;

public class HouseRobberBetter {
    public int rob(int[] nums) {

        int N = nums.length;
        if (N == 0) {
            return 0;
        }

        int nextHousePlusOne = 0;
        int nextHouse = nums[N-1];

        for (int i = N - 2; i >= 0; --i) {
            int current = Math.max(nextHouse, nextHousePlusOne + nums[i]);

            nextHousePlusOne = nextHouse;
            nextHouse = current;
        }

        return nextHouse;
    }
}
