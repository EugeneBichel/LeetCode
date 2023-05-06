package com.bichel.spotify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {
    /**
     * Method under test: {@link TwoSum#getIndices(int[], int)}
     */
    @Test
    void testGetIndices() {
        int[] actualIndices = (new TwoSum()).getIndices(new int[]{1000, 1000, 1000, 1000}, 1);
        assertEquals(2, actualIndices.length);
        assertEquals(0, actualIndices[0]);
        assertEquals(0, actualIndices[1]);
    }

    /**
     * Method under test: {@link TwoSum#getIndices(int[], int)}
     */
    @Test
    void testGetIndices2() {
        int[] actualIndices = (new TwoSum()).getIndices(new int[]{2, -1, 1000, 1000}, 1);
        assertEquals(2, actualIndices.length);
        assertEquals(0, actualIndices[0]);
        assertEquals(1, actualIndices[1]);
    }

    /**
     * Method under test: {@link TwoSum#getIndices(int[], int)}
     */
    @Test
    void testGetIndices3() {
        int[] actualIndices = (new TwoSum()).getIndices(new int[]{2, -1, 1000, 1000}, 4);
        assertEquals(2, actualIndices.length);
        assertEquals(0, actualIndices[0]);
        assertEquals(0, actualIndices[1]);
    }
}

