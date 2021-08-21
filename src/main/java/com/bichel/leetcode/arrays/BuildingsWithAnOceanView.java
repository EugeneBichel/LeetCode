package com.bichel.leetcode.arrays;

import java.util.List;
import java.util.ArrayList;

/*
There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.


Example 1:
Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 */

public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        int len = heights.length;
        List<Integer> indx = new ArrayList<>();
        indx.add(len-1);

        int max = heights[len-1];

        for(int i=len-2; i>=0; i--) {
            if(heights[i] > max) {
                max=heights[i];
                indx.add(i);
            }
        }

        int[] ans = new int[indx.size()];
        int i = ans.length-1;
        for(Integer ind: indx) {
            ans[i--] = ind;
        }

        return ans;
    }
}
