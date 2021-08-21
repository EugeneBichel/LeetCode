package com.bichel.leetcode.stacks;

/*
["MinStack","push","push","push","top","pop","getMin","pop","getMin",
"pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],
[],[],[-2147483648],[],[],[],[]]
 */

public class MinStack {
    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(2147483646);
        st.push(2147483646);
        st.push(2147483647);
        st.top(); //2147483647
        st.pop();
        st.getMin(); //2147483646
        st.pop();
        st.getMin(); //2147483646
        st.pop();
        st.push(2147483647);
        st.top();
        st.getMin();
        st.pop();
        st.getMin();
    }

    int capacity = 16;
    int topInd = -1;
    int bottomInd = 0;
    int min = Integer.MAX_VALUE;
    int[] data;

    /** initialize your data structure here. */
    public MinStack() {
        data = new int[capacity];
    }

    public void push(int val) {
        topInd++;
        if(bottomInd < 0) bottomInd = 0;

        data[topInd] = val;
        if(val < min) min = val;

        if(topInd >= capacity-1) {
            capacity *= 2;
            int[] temp = new int[capacity];
            for(int i=bottomInd;i<=topInd;i++) temp[i] = data[i];

            data = temp;
        }
    }
    public void pop() {

        if(topInd < 0) return;

        topInd--;
        if(topInd < 0) {
            min = Integer.MAX_VALUE;
            bottomInd = topInd;
            return;
        }

        min = data[bottomInd];
        for(int i = bottomInd+1; i<=topInd; i++) {
            if(min > data[i]) min = data[i];
        }
    }
    public int top() {
        return data[topInd];
    }
    public int getMin() {
        return min;
    }
}
