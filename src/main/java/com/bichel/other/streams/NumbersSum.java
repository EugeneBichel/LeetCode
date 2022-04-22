package com.bichel.other.streams;

import java.util.ArrayList;
import java.util.List;

public class NumbersSum {
    public static void main(String[] args) {
        List<Long> numbers = getNumbers();
        Long result = numbers.parallelStream().map(num -> num % 2).reduce(0l, Long::sum);

        System.out.println(result);
    }

    static List<Long> getNumbers() {
        List<Long> numbers = new ArrayList<>();

        for (long i = 1000; i > 0; i--) {
            numbers.add(i);
        }

        return numbers;
    }
}
