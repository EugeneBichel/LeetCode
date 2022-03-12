package com.bichel.fbrecruiting;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalanceBrackets {
    boolean isBalanced(String s) {
        Deque<Character> q = new ArrayDeque<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[')
                q.push(ch);
            else if (ch == '}' && q.peek() != '{') return false;
            else if (ch == ')' && q.peek() != '(') return false;
            else if (ch == ']' && q.peek() != '[') return false;
            else q.pop();
        }

        return q.isEmpty();
    }
}
