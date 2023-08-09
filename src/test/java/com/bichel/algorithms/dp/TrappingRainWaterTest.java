package com.bichel.algorithms.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bichel.algorithms.problemsheap.dp.TrappingRainWater;
import org.junit.jupiter.api.Test;

public class TrappingRainWaterTest {

    @Test
    public void testTestCase1() {
        TrappingRainWater pr = new TrappingRainWater();

        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        int volume = pr.trap(heights);

        assertEquals(6, volume);
    }

    @Test
    public void testTestCase2() {
        TrappingRainWater pr = new TrappingRainWater();

        int[] heights = {4,2,3};

        int volume = pr.trap(heights);

        assertEquals(1, volume);
    }

    @Test
    public void testTestCase3() {
        TrappingRainWater pr = new TrappingRainWater();

        int[] heights = {5,4,1,2};

        int volume = pr.trap(heights);

        assertEquals(1, volume);
    }
}
