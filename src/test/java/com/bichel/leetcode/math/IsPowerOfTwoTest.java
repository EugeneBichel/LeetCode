package com.bichel.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsPowerOfTwoTest {
    @Test
    public void testTestCase1() {
        IsPowerOfTwo pr = new IsPowerOfTwo();

        Assertions.assertTrue(pr.isPowerOfTwo(16));
    }
}
