package com.bichel.algorithms.disjoint_set_union;

import java.util.Arrays;

/*
There are n people in a social group labeled from 0 to n - 1.
You are given an array logs where logs[i] = [timestampi, xi, yi]
indicates that xi and yi will be friends at the time timestampi.

Friendship is symmetric. That means if a is friends with b,
then b is friends with a. Also, person a is acquainted with a person b
if a is friends with b, or a is a friend of someone acquainted with b.

Return the earliest time for which every person became acquainted with every other person.
If there is no such earliest time, return -1.
 */

public class TheEarliestMomentWhenEveryoneBecomeFriends {

    public int earliestAcq(int[][] logs, int n) {

        // First, we need to sort the events in chronological order.
        Arrays.sort(logs, (log1, log2) -> {
            Integer tsp1 = log1[0];
            Integer tsp2 = log2[0];
            return tsp1.compareTo(tsp2);
        });

        // Initially, we treat each individual as a separate group.
        int groupCount = n;
        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int timestamp = log[0];
            int friendA = log[1];
            int friendB = log[2];

            // We merge the groups along the way.
            if (uf.union(friendA, friendB)) {
                groupCount -= 1;
            }

            // The moment when all individuals are connected to each other.
            if (groupCount == 1) {
                return timestamp;
            }
        }

        // There are still more than one groups left,
        //  i.e. not everyone is connected.
        return -1;
    }
}
