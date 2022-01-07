package com.bichel.classicproblems.interval;

/*
There is a car with capacity empty seats. The vehicle only drives east (i.e.,
it cannot turn around and drive west).

You are given the integer capacity and an array trips
where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers
and the locations to pick them up and drop them off are fromi and toi respectively.
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips,
or false otherwise.

Example 1:
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Constraint
1 <= trips.length <= 1000
 */

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    public boolean carPoolingUsingMap(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<>();

        for (int[] trip : trips) {
            int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
            timestamp.put(trip[1], startPassenger);

            int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
            timestamp.put(trip[2], endPassenger);
        }

        int usedCapacity = 0;
        for (int passengerChange : timestamp.values()) {
            usedCapacity += passengerChange;
            if (usedCapacity > capacity) {
                return false;
            }
        }

        return true;
    }

    public boolean carPoolingUsingBucketSort(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];

        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;
        for (int number : timestamp) {
            usedCapacity += number;
            if (usedCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}
