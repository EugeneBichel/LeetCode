package com.bichel.algorithms.problemsheap.stacks;

public class MaxStack {
    private int capacity = 16;
    private int topInd = -1;
    private int bottomInd = 0;
    private int max = Integer.MIN_VALUE;
    private int[] data;

    public MaxStack() {
        data = new int[capacity];
    }

    public void push(int val) {
        topInd++;
        if(bottomInd < 0) bottomInd = 0;

        data[topInd] = val;
        if(val > max) max = val;

        if(topInd >= capacity-1) {
            capacity *= 2;
            int[] temp = new int[capacity];
            for(int i=bottomInd;i<=topInd;i++) temp[i] = data[i];

            data = temp;
        }
    }
    public int pop() {

        if(topInd < 0) return -1;
        else {
            int item = data[topInd];
            topInd--;

            max = data[bottomInd];
            for(int i = bottomInd+1; i<=topInd; i++) {
                if(max < data[i]) max = data[i];
            }

            return item;
        }
    }
    public int top() {
        return data[topInd];
    }
    public int peekMax() {
        return max;
    }
    public int popMax() {
        int val = max;

        int maxInd = -1;
        for(int i = bottomInd; i <= topInd; i++) {

            if(data[i] == max) {
                maxInd = i;
                break;
            }
        }

        for(int i = maxInd+1; i <= topInd; i++) {
            data[i-1] = data[i];
        }

        max = Integer.MIN_VALUE;
        topInd = topInd-1;

        for(int i = bottomInd; i <= topInd; i++) {

            if(data[i] > max)
                max = data[i];
        }

        return val;
    }
}
