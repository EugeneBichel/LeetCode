package com.bichel.algorithms.problemsheap.math.easy;

public class CountOddNumbersInAnIntervalRange {
    /*
        the count of odd numbers between 1 and low - 1 is low / 2
        the count of odd numbers between 1 and high is (high + 1 ) / 2
        */
    public int countOdds(int low, int high) {
        return (1 + high) / 2 - (1 + low - 1) / 2;
    }
}
