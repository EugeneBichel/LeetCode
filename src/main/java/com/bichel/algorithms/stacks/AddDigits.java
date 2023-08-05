package com.bichel.algorithms.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an integer num, repeatedly add all its digits until
the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
 */

public class AddDigits {
    public int addDigits(int num) {

        Deque<Integer> stack = new ArrayDeque<>();

        while( num >= 10 ) {

            while(num > 0) {
                stack.push(num % 10);
                num /= 10;
            }

            while(!stack.isEmpty()) {
                num += stack.pop();
            }

        }
        return num;
    }
}
