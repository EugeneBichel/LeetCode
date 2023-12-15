package com.bichel.algorithms.companies.meta;

/*
iven an int array wood representing the length of n pieces of wood and an int k. It is required to cut these pieces of wood such that more or equal to k pieces of the same length len are cut. What is the longest len you can get?

Example 1:

Input: wood = [5, 9, 7], k = 3
Output: 5
Explanation:
5 -> 5
9 -> 5 + 4
7 -> 5 + 2

also:
https://www.geeksforgeeks.org/maximum-length-of-all-possible-k-equal-length-ropes-generated-by-cutting-n-ropes/
 */

public class CutWoods {
    public boolean isValid(int[] wood, int cutLength, int k) {
        int count = 0;
        for (int w : wood) {
            count += w / cutLength;
        }
        return count >= k;
    }

    public int cutWood(int[] wood, int k) {
        // corner cases:
        if (wood.length == 0 || k == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        int res = 0;
        if (!isValid(wood, left, k)) return 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean valid = isValid(wood, mid, k);
            if (valid) {
                left = mid + 1;
                res = mid;
            } else
                right = mid;
        }
        return res;
    }
}
