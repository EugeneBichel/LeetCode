package com.bichel.facebook;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

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

public class MovingAverageFromDataStream {
    private int[] arr;
    private int size;
    private int ind = 0;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        arr = new int[size];
    }

    public double next(int val) {
        if(ind < size) {
            arr[ind++] = val;
        } else {
            for (int i = 0; i < ind - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[size - 1] = val;
        }

        int sum = 0;
        for(int i = 0; i < ind; i++) {
            sum += arr[i];
        }

        return (double) sum / Math.min(sum, ind);
    }
}

class MovingAverage {
    int size;
    int windowSum;
    int count;
    Deque queue;

    public MovingAverage(int size) {
        this.size = size;
        windowSum = 0;
        count = 0;
        queue = new ArrayDeque<Integer>();
    }

    public double next(int val) {
        count++;

        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(size, count);
    }
}