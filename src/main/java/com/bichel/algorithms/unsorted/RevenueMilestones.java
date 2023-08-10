package com.bichel.algorithms.unsorted;

/*
We keep track of the revenue Facebook makes every day,
and we want to know on what days Facebook hits certain revenue milestones.
 Given an array of the revenue on each day, and an array of milestones Facebook wants to reach,
 return an array containing the days on which Facebook reached every milestone.
Signature
int[] getMilestoneDays(int[] revenues, int[] milestones)

Input
revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N).
 milestones is a length-K array of total revenue milestones.

Output
Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue.
If the milestone is never met, return -1.

Example
revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
milestones = [100, 200, 500]
output = [4, 6, 10]

Explanation
On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively.
Day 6 is the first time that FB has >= $200 of total revenue.
 */

public class RevenueMilestones {
    private int[] sum;

    public int[] getMilestoneDays(int[] revenues, int[] milestones) {

        int[] result = new int[milestones.length];

        sum = new int[revenues.length];
        sum[0] = revenues[0];

        //keep a cumulative sum to do binary search on
        for (int i = 1; i < revenues.length; i++) {
            sum[i] = sum[i - 1] + revenues[i];
        }

        for (int i = 0; i < milestones.length; i++) {
            int day = binarySearch(milestones[i]);
            result[i] = day + 1;
        }

        return result;
    }

    private int binarySearch(int target) {
        int left = 0;
        int right = sum.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left < sum.length ? left : -1; //check if found index is valid or going out of bounds
    }
}
