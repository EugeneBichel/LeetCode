package com.bichel.algorithms.sort;

import java.util.Stack;

public class StackSort {
    public static void sort(Stack<Integer> S) {
        if(S.empty()) {
            return;
        }

        Integer item = S.pop();
        sort(S);
        makeSortedStack(S, item);
    }

    private static void makeSortedStack(Stack<Integer> S, Integer item) {
        if(S.empty() || S.peek() < item) {
            S.push(item);
        } else {
            Integer topItem = S.pop();
            makeSortedStack(S, item);
            S.push(topItem);
        }
    }
}
