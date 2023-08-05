package com.bichel.algorithms.math;

/*
On an infinite plane, a robot initially stands at (0, 0) and faces north.
The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if
there exists a circle in the plane
such that the robot never leaves the circle.
 */

public class RobotBounded {
    public boolean isRobotBounded(String s) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Initial position is in the center
        int x = 0, y = 0;

        // facing north
        int idx = 0;

        for (char i : s.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4; //west
            else if (i == 'R')
                idx = (idx + 1) % 4; //east
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
