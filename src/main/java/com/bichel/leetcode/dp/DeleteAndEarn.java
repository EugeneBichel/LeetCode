package com.bichel.leetcode.dp;

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

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];

        for (int x : nums) {
            count[x]++;
        }

        int avoid = 0, using = 0, prev = -1;

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
