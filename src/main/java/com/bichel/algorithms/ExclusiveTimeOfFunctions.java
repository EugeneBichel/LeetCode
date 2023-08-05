package com.bichel.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
On a single-threaded CPU, we execute a program containing n functions.
Each function has a unique ID between 0 and n-1.
Function calls are stored in a call stack: when a function call starts,
its ID is pushed onto the stack, and when a function call ends,
its ID is popped off the stack. The function whose ID is at the top of the stack is
the current function being executed. Each time a function starts or ends,
we write a log with the ID, whether it started or ended, and the timestamp.
You are given a list logs, where logs[i] represents the ith log message
formatted as a string "{function_id}:{"start" | "end"}:{timestamp}".
For example, "0:start:3" means a function call with function ID 0 started
at the beginning of timestamp 3, and "1:end:2" means a function call with
function ID 1 ended at the end of timestamp 2. Note that a function
can be called multiple times, possibly recursively.
A function's exclusive time is the sum of execution times for
all function calls in the program. For example, if a function is called twice,
one call executing for 2 time units and another call executing for 1 time unit,
the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array,
where the value at the ith index represents the exclusive
time for the function with ID i.
 */

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");

            if (!stack.isEmpty())
                res[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;

            prevTime = Integer.parseInt(parts[2]);

            if (parts[1].equals("start"))
                stack.push(Integer.parseInt(parts[0]));
            else {
                res[stack.pop()]++;
                prevTime++;
            }
        }

        return res;
    }
}
