package com.bichel.algorithms.math;

import com.bichel.algorithms.problemsheap.math.Pow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowTest {
    @Test
    void testPow() {
        Pow program = new Pow();
        double result = program.myPow(2.0, 3);

        assertEquals(8.0, result);
    }
}
