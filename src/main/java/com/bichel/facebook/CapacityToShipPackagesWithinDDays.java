package com.bichel.facebook;

/*
A conveyor belt has packages that must be shipped
from one port to another within days days.
The ith package on the conveyor belt has a weight of weights[i].
Each day, we load the ship with packages on the conveyor belt
(in the order given by weights). We may not load more weight than
the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result
in all the packages on the conveyor belt being shipped within days days.
 */

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int allWeights = 0;

        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            allWeights += w;
        }

        int left = maxWeight;
        int right = allWeights;

        while (left < right) {
            int mid = (left + right) / 2;
            int need = 1;
            int cur = 0;

            for (int w : weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }

            if (need > days) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
