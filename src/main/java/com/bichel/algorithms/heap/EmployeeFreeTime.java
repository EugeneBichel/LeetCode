package com.bichel.algorithms.heap;

/*
We are given a list schedule of employees,
which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals,
and these intervals are in sorted order.

Return the list of finite intervals representing common,
positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y],
the objects inside are Intervals, not lists or arrays.
For example, schedule[0][0].start = 1, schedule[0][0].end = 2,
and schedule[0][0][0] is not defined).
Also, we wouldn't include intervals like [5, 5] in our answer,
as they have zero length.
 */

import com.bichel.algorithms.Interval;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> allIntervals =
                new PriorityQueue<>((i1, i2) -> i1.start - i2.start);

        List<Interval> result = new ArrayList<>();
        for (List<Interval> list : schedule) {
            allIntervals.addAll(list);
        }

        while (allIntervals.size() > 1) {
            Interval first = allIntervals.poll();
            Interval second = allIntervals.poll();

            if (second.start > first.end) {
                result.add(new Interval(first.end, second.start));
            }

            if (first.end > second.end) {
                allIntervals.add(first);
            } else {
                allIntervals.add(second);
            }
        }

        return result;
    }
}
