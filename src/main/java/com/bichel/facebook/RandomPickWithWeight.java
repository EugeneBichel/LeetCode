package com.bichel.facebook;

/*
You are given an array of positive integers w
where w[i] describes the weight of ith index (0-indexed).
We need to call the function pickIndex() which randomly
returns an integer in the range [0, w.length - 1].
pickIndex() should return the integer proportional
to its weight in the w array.
For example, for w = [1, 3], the probability of picking the index 0 is
 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of picking the index 1
 is 3 / (1 + 3) = 0.75 (i.e 75%).

More formally, the probability of picking index i is w[i] / sum(w).


Time Complexity:
- For the constructor function, the time complexity would be O(N),
which is due to the construction of the prefix sums.
- For the pickIndex() function, its time complexity would be O(N) as well,
since we did a linear search on the prefix sums.

Space Complexity:
For the pickIndex() function,
its space complexity would be O(1), since it uses constant memory.
Note, here we consider the prefix sums that it operates on, as the input of the function.

 */

public class RandomPickWithWeight {
    private int[] prefixSums;
    private int totalSum;

    public RandomPickWithWeight(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }

        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();

        // run a linear search to find the target zone
        for (int i = 0; i < this.prefixSums.length; i++) {
            if (target < this.prefixSums[i])
                return i;
        }

        // to have a return statement, though this should never happen.
        return -1;
    }
}
