package com.bichel.algorithms;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an array S of n integers, find three integers in S such
 that the sum is closest to a given number, target.
Return the sum of the three integers.
Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

Complexity Analysis

Time Complexity: O(n^2log(n))
Binary search takes O(logn), and we do it nn times in the inner loop.
Since we are going through nn elements in the outer loop, the overall complexity is
O(n^2log(n))

Space Complexity: from O(logn) to O(n),
depending on the implementation of the sorting algorithm.
 */

public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> num, int target) {
        Collections.sort(num);

        int result = num.get(0) + num.get(1) + num.get(num.size() - 1);

        for (int i = 0; i < num.size() - 2; i++) {
            int start = i + 1;
            int end = num.size() - 1;

            while (start < end) {
                int sum = num.get(i) + num.get(start) + num.get(end);

                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else return sum;

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
