package com.bichel.other.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        arr.sort(Comparator.naturalOrder());

        /*
            A stream is a sequence of elements supporting sequential and parallel aggregate operations.

            Streams are lazy; computation on the source data is only performed when the
                terminal operation is initiated, and source elements are consumed only
                as needed.
         */

        List<String> list = Stream.of("A", "B", "C", "D", "E", "F").collect(Collectors.toList());
    }
}
