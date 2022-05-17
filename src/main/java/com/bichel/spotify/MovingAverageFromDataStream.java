package com.bichel.spotify;

/*
Given a stream of integers and a window size,
calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.


Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MovingAverageFromDataStream {
    private int size;
    private int windowSum;
    private int count;
    private Queue<Integer> queue;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        windowSum = 0;
        count = 0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        count++;

        queue.offer(val);
        int tail = count > size ? (int)queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(size, count);
    }
}