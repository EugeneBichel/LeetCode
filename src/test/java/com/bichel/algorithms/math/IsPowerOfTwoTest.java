package com.bichel.algorithms.math;

import com.bichel.algorithms.problemsheap.math.IsPowerOfTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPowerOfTwoTest {
    @Test
    void testTestCase1() {
        IsPowerOfTwo program = new IsPowerOfTwo();
        assertTrue(program.isPowerOfTwo(16));
    }
}
