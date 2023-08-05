package com.bichel.algorithms.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(Character ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if(st.isEmpty() && (
                    ch == ')' || ch == '}' || ch == ']'))
                return false;
            else if(!st.isEmpty() && (
                    ch == ')' || ch == '}' || ch == ']')){
                char c = st.pop();

                if(ch == ')' && c !='(') return false;
                if(ch == ']' && c !='[') return false;
                if(ch == '}' && c !='{') return false;

            }
        }

        return st.isEmpty();
    }
}
