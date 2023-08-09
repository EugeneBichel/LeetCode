package com.bichel.algorithms.arrays;

import com.bichel.algorithms.problemsheap.arrays.RobotBoundedInCircle;
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
