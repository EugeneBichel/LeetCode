package com.bichel.algorithms.problemsheap.dp;

/*
You are given an integer array nums.
You want to maximize the number of points you get by performing
the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points.
Afterwards, you must delete every element equal to nums[i] - 1
and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying
the above operation some number of times.

Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nu
 */

import java.util.HashMap;

public class DeleteAndEarn {

    /*
    Using recursion

    Given N as the length of nums and
        k as the maximum element in nums,
    Time complexity: O(N + k)

    To populate points, we need to iterate through nums once,
    which costs O(N) time. Then, we populate maxPoints by iterating over it.
    The length of maxPoints is equal to k + 1,
    so this will cost O(k) time. Our final time complexity is O(N + k).

    Space complexity: O(N + k)

    The extra space we use is the hash table points and our DP array maxPoints.
    The size of maxPoints is equal to k + 1, which means it takes O(k) space.
    The size of points is equal to the number of unique elements in nums.
    In the worst case, where every element in nums is unique,
    this will take O(N) space. Our final space complexity is O(N + k).
     */
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> cache = new HashMap<>();
    private int maxPoints(int num) {
        // Check for base cases
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        // Apply recurrence relation
        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        return cache.get(num);
    }
    public int deleteAndEarnUsingRecursion(int[] nums) {
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        return maxPoints(maxNumber);
    }

    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];

        for (int x : nums) {
            count[x]++;
        }

        int avoid = 0;
        int using = 0;
        int prev = -1;

        for (int k = 0; k < count.length; ++k) {
            if (count[k] > 0) {
                int m = Math.max(avoid, using);

                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        }

        return Math.max(avoid, using);
    }
}
