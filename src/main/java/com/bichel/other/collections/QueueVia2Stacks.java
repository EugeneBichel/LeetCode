package com.bichel.other.collections;

import java.util.*;

public class QueueVia2Stacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Deque<Integer> inStack = new ArrayDeque<>();
        Deque<Integer> outStack = new ArrayDeque<>();

        Scanner input = new Scanner(System.in);
        int qNumber = input.nextInt();

        while( qNumber > 0 ) {
            qNumber--;

            int qType = input.nextInt();
            if(qType == 1) {
                int value = input.nextInt();
                inStack.add(value);
            } else if(qType == 2) {
                if(outStack.isEmpty()) {
                    while(!inStack.isEmpty()) {
                        outStack.add(inStack.pop());
                    }
                }
                outStack.pop();
            } else if(qType == 3) {
                if(outStack.isEmpty()) {
                    while(!inStack.isEmpty()) {
                        outStack.add(inStack.pop());
                    }
                }
                System.out.println(outStack.peek());
            }
        }
    }
}