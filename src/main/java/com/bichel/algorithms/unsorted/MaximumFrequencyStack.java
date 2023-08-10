package com.bichel.algorithms.unsorted;

/*
Design a stack-like data structure to push elements
to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest
to the stack's top is removed and returned.

Time Complexity: O(1) for both push and pop operations.
Space Complexity: O(N), where N is the number of elements in the FreqStack.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> group;
    int maxFreq;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);

        if (f > maxFreq)
            maxFreq = f;

        group.computeIfAbsent(f, z-> new ArrayDeque<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxFreq).pop();

        freq.put(x, freq.get(x) - 1);

        if (group.get(maxFreq).isEmpty())
            maxFreq--;

        return x;
    }
}
