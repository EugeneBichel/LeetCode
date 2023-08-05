package com.bichel.algorithms;

import java.util.ArrayList;

/*
iven n non-negative integers a1, a2, ..., an,

where each represents a point at coordinate (i, ai).

'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

Note: You may not slant the container.

Example :
Input : [1, 5, 4, 3]
Output : 6

Time complexity : O(n). Single pass.
Space complexity : O(1). Constant space is used.
 */

public class ContainerWithMostWater {
    public int maxArea(ArrayList<Integer> height) {
        int maxArea = 0;
        int l = 0;
        int r = height.size() - 1;

        while (l < r) {
            maxArea = Math.max(maxArea,
                    Math.min(height.get(l), height.get(r)) * (r - l));

            if (height.get(l) < height.get(r))
                l++;
            else
                r--;
        }

        return maxArea;
    }
}
