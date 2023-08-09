package com.bichel.algorithms.companies.ibm;

/*
There are n gas stations along a circular route,
 where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i]
of gas to travel from the ith station to its next (i + 1)th station.
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost,
return the starting gas station's index if you can travel around
the circuit once in the clockwise direction, otherwise return -1.
If there exists a solution, it is guaranteed to be unique

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas.
Your tank = 0 + 4 = 4
Travel from 3 to station 4. Your tank = 4 - 1 + 5 = 8 // cost is 1 cost[3] = 1
Travel from 4 to station 0. Your tank = 8 - 2 + 1 = 7 // cost is 2 cost[4] = 2
Travel from 0 to station 1. Your tank = 7 - 3 + 2 = 6 // cost is 3 cost[0] = 3
Travel from 1 to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
 */

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int currTank = 0;

        int startingStation = 0;

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            // If one couldn't get here,
            if (currTank < 0) {
                // Pick up the next station as the starting one.
                startingStation = i + 1;
                // Start with an empty tank.
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }
}
