package com.bichel.leetcode.stacks;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

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
