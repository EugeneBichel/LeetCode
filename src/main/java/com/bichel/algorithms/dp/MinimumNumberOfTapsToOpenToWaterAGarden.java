package com.bichel.algorithms.dp;

/*
There is a one-dimensional garden on the x-axis.
The garden starts at the point 0 and ends at the point n.
(i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.

Given an integer n and an integer array ranges of length n + 1
where ranges[i] (0-indexed) means the i-th tap can water
the area [i - ranges[i], i + ranges[i]] if it was open.

Return the minimum number of taps that should be open to water the whole garden,
If the garden cannot be watered return -1.

Similar problems:
This problem is similiar to Jump game II and Video Stiching.
Just summary a general idea to process this kind of problems
for the conveninece of review in the future.
(Welcome supplement other similar ones, thanks in advance).

First we need ensure that the array has been sorted by start time.
Then say in each step, we have a range [left, right],
which means we can only visit the elements within the range in this step.
We keep checking the elements until we are at the rightmost position in [left, right]
to update "farCanReach" , which means the farthest we can reach in next step.


 */

public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public int minTaps(int n, int[] ranges) {
        // construct the arr
        int[] arr = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        // same part like previous problem
        int end = 0, farCanReach = 0, cnt = 0;
        for (int i = 0; i < arr.length && end < n; end = farCanReach) {
            cnt++;
            while (i < arr.length && i <= end) {
                farCanReach = Math.max(farCanReach, arr[i++]);
            }
            if (end == farCanReach) return -1;
        }
        return cnt;
    }
}
