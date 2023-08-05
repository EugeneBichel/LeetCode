package com.bichel.algorithms.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KLargestTest {
    @Test
    public void testTestCase1() {
        KLargest program = new KLargest();
        int[] a = {3, 2, 1, 5, 6, 4};

        int val = program.solutionUsingHeap(a, 2);

        assertEquals(val, 5);
    }
}
