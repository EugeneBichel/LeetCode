package com.bichel.algorithms.companies.meta;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> indsSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!queue.isEmpty()) {
                    queue.pop();
                } else {
                    indsSet.add(i);
                }
            } else if (s.charAt(i) == '(') {
                queue.push(i);
            }
        }

        while (!queue.isEmpty()) {
            indsSet.add(queue.pop());
        }

        for (int i = 0; i < s.length(); i++) {
            if (!indsSet.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
