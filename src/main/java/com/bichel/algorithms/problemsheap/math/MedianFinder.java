package com.bichel.algorithms.problemsheap.math;

/*
The median is the middle value in an ordered integer list.
If the size of the list is even, there is no middle value and the median is
the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far.
Answers within 10-5 of the actual answer will be accepted.
 */

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    List<Integer> nums;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        int i = 0;
        for (; i < nums.size(); i++) {
            if (num < nums.get(i)) {
                nums.add(i, num);
                break;
            }
        }

        if (i == nums.size()) nums.add(num);
    }

    public double findMedian() {
        if (nums.size() % 2 != 0) {
            return nums.get((nums.size() - 1) / 2);
        } else {

            int ix1 = (nums.size() / 2) - 1;
            int ix2 = (nums.size() / 2);

            return (double) ((nums.get(ix1) + nums.get(ix2))) / 2;
        }
    }
}
