package com.bichel.leetcode.stacks;

/*
Given a balanced parentheses string s, return the score of the string.
The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {
    /*
    Intuition and Algorithm
    Every position in the string has a depth -
    some number of matching parentheses surrounding it.
    For example, the dot in (()(.())) has depth 2,
    because of these parentheses: (__(.__))
    Our goal is to maintain the score at the current depth we are on.
    When we see an opening bracket, we increase our depth,
    and our score at the new depth is 0.
    When we see a closing bracket, we add twice the score of the previous deeper part -
    except when counting (), which has a score of 1.

    For example, when counting (()(())), our stack will look like this:

    [0, 0] after parsing (
    [0, 0, 0] after (
    [0, 1] after )
    [0, 1, 0] after (
    [0, 1, 0, 0] after (
    [0, 1, 1] after )
    [0, 3] after )
    [6] after )

    */

    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); //the score of the current frame

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop(); //score of the ith depth
                int w = stack.pop(); //score of the (i-1)th depth

                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
