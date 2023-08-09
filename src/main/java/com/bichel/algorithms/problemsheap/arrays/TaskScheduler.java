package com.bichel.algorithms.problemsheap.arrays;

import java.util.Arrays;

/*
Given a characters array tasks, representing the tasks a CPU needs to do,
where each letter represents a different task.
Tasks could be done in any order. Each task is done in one unit of time.
For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period
between two same tasks (the same letter in the array),
that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU
will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;

     /*
     1. Sort tasks by frequency
     2. Schedule the next by frequency
     3. Schedule the next by grequency
     ...
     n. All tasks scheduled.

     idle_time = ( f_max -1 ) * n;

     Pick the elements in the desc order one by one.
     At each step, decrease the idle time by
     min(f_max - 1, f), where f is a current frequency.

     Return busy slots + idle slots: len(tasks) + idle_time
     */

        // frequencies of the tasks
        int[] frequencies = new int[26]; // 'A' - 'Z'
        for(int t: tasks) {
            frequencies[t- 'A']++;
        }

        Arrays.sort(frequencies);

        int fMax = frequencies[frequencies.length - 1];
        int idleTime = (fMax - 1) * n;

        for(int i=frequencies.length-2; i>=0 && idleTime > 0; i--) {
            idleTime -= Math.min(fMax-1, frequencies[i]);
        }

        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }
}
