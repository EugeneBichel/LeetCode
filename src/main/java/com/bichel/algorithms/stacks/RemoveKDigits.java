package com.bichel.algorithms.stacks;

/*
Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
which is the smallest.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }

            stack.addLast(digit);
        }

        //if k > 0
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        StringBuilder ans = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;

            leadingZero = false;
            ans.append(digit);
        }

        if (ans.length() == 0)
            return "0";

        return ans.toString();
    }
}
