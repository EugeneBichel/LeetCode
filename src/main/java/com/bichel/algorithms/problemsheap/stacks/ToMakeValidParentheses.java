package com.bichel.algorithms.problemsheap.stacks;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class ToMakeValidParentheses {
    class Pair {
        int index;
        char ch;

        public Pair() {
        }

        public Pair(int index, char ch) {
            this.index = index;
            this.ch = ch;
        }
    }

    public String minRemoveToMakeValid(String s) {
        char[] a = s.toCharArray();
        List<Character> out = new ArrayList<>();

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                out.add(a[i]);
                st.push(new Pair(out.size() - 1, a[i]));
            } else if (a[i] == ')') {
                if (!st.isEmpty()) {
                    out.add(a[i]);
                    st.pop();
                }
            } else {
                out.add(a[i]);
            }
        }

        while (!st.isEmpty()) {
            out.remove(st.pop().index);
        }

        StringBuilder sb = new StringBuilder();
        out.forEach(ch -> sb.append(ch));

        return sb.toString();

    }
}
