package com.bichel.facebook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinimumRemoveToMakeValidParentheses {
    class Pair {
        int index;
        char ch;

        public Pair(int index, char ch) {
            this.index = index;
            this.ch = ch;
        }
    }

    public String minRemoveToMakeValid(String s) {
        List<Character> out = new ArrayList<>();
        Deque<Pair> st = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                out.add(c);
                st.push(new Pair(out.size() - 1, c));
            } else if (c == ')') {
                if (!st.isEmpty()) {
                    out.add(c);
                    st.pop();
                }
            } else {
                out.add(c);
            }
        }

        while (!st.isEmpty()) {
            out.remove(st.pop().index);
        }

        StringBuilder sb = new StringBuilder();
        out.forEach(sb::append);

        return sb.toString();
    }
}
