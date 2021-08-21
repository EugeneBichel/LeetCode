package com.bichel.leetcode.arrays;

import org.junit.jupiter.api.Test;

public class RobotBoundedInCircleTest {

    @Test
    public void testTestCase1() {
        RobotBoundedInCircle pr = new RobotBoundedInCircle();

        String instructions = "GGLLGG";

        boolean isCircle = pr.isRobotBounded(instructions);

        System.out.println(isCircle);
    }
}
