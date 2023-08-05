package com.bichel.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s.
In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis
to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.
 */

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int counter = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) counter++;
                else stack.pop();
            }
        }

        return stack.size() + counter;
    }
}
