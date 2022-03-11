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

        int leftWeight = maxWeight;
        int rightWeight = allWeights;

        while (leftWeight < rightWeight) {
            int midWeight = (leftWeight + rightWeight) / 2;

            int needDays = 1;
            int curShipCapacity = 0;

            for (int w : weights) {
                if (midWeight < curShipCapacity + w) {
                    needDays += 1;
                    curShipCapacity = 0;
                }

                curShipCapacity += w;
            }

            if (needDays > days)
                leftWeight = midWeight + 1;
            else
                rightWeight = midWeight;
        }

        return leftWeight;
    }
}
