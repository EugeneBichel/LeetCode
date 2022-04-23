package com.bichel.leetcode.sort;

import java.util.Stack;

public class StackSortTest {
    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 2, 9, 4, 7, 6, 8, 0};

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(4);
        stack.push(7);
        stack.push(6);
        stack.push(8);
        stack.push(0);

        sort(stack);

        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void sort(Stack<Integer> stack) {
        stackSort(stack);
    }

    private static void stackSort(Stack<Integer> stack) {

        if(stack.empty()) {
            return;
        }

        Integer top = stack.pop();
        stackSort(stack);

        makeStackSort(stack, top);
    }

    private static void makeStackSort(Stack<Integer> stack, Integer top) {

        if(stack.empty() || top < stack.peek()) {
            stack.push(top);
        } else {

            Integer temp = stack.pop();
            makeStackSort(stack, top);
            stack.push(temp);
        }
    }
}
