package com.bichel.algorithms.problemsheap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
Given an array of integers A .

A represents a histogram i.e A[i] denotes height of the ith histogram's bar.
Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int length = heights.size();
        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (heights.get(stack.peek()) >= heights.get(i))) {
                int currentHeight = heights.get(stack.pop());
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currentHeight = heights.get(stack.pop());
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
