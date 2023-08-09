package com.bichel.algorithms.problemsheap.sort;

import java.util.Arrays;

/*
A company is planning to interview 2n people.
Given the array costs where costs[i] = [aCosti, bCosti],
the cost of flying the ith person to city a is aCosti,
and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person
to a city such that exactly n people arrive in each city.

Time complexity : O(NlogN) because of sorting of input data.
Space complexity : O(1) since it's a constant space solution.
 */

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));

        int total = 0;
        int n = costs.length / 2;
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; i++)
            total += costs[i][0] + costs[i + n][1];

        return total;
    }
}
