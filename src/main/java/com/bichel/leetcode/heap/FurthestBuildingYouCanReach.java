package com.bichel.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given an integer array heights representing the heights of buildings,
some bricks, and some ladders.

You start your journey from building 0 and move to the next building
by possibly using bricks or ladders.

While moving from building i to building i+1 (0-indexed),

If the current building's height is greater than or equal to the next building's height,
you do not need a ladder or bricks.
If the current building's height is less than the next building's height,
you can either use one ladder or (h[i+1] - h[i]) bricks.


 */

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Create a priority queue with a comparator that makes it behave as a min-heap.
        Queue<Integer> ladderAllocations = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            // If this is actually a "jump down", skip it.
            if (climb <= 0) {
                continue;
            }
            // Otherwise, allocate a ladder for this climb.
            ladderAllocations.add(climb);
            // If we haven't gone over the number of ladders, nothing else to do.
            if (ladderAllocations.size() <= ladders) {
                continue;
            }
            // Otherwise, we will need to take a climb out of ladder_allocations
            bricks -= ladderAllocations.remove();
            // If this caused bricks to go negative, we can't get to i + 1
            if (bricks < 0) {
                return i;
            }
        }
        // If we got to here, this means we had enough materials to cover every climb.
        return heights.length - 1;
    }
}
