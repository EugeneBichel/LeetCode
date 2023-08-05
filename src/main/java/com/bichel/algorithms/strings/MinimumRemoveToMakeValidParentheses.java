package com.bichel.algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


 */

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> indToRemove = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')') {
                if( !stack.isEmpty()) {
                    stack.pop();
                } else {
                    indToRemove.add(i);
                }
            }
        }

        while(!stack.isEmpty()) {
            indToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(!indToRemove.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
