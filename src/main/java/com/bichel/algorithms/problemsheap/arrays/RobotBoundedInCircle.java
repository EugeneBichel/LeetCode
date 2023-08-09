package com.bichel.algorithms.problemsheap.arrays;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{
                {0, 1}, //x=0, y=1 north | idx + 0
                {1, 0}, //x=1, y=0 east | idx + 1
                {0, -1}, //x=0, y=-1 south
                {-1, 0} //x=-1, y=0 west | idx + 3
        };
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}
