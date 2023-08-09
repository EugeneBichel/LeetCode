package com.bichel.algorithms.problemsheap.arrays.easy;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];

            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }

        return (sum - min - max) / (salary.length - 2);
    }
}
