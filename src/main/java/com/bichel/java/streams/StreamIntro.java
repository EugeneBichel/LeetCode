package com.bichel.java.streams;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;

public class StreamIntro {
    /*
    The addition of the Stream API was one of the major features added to Java 8.
    A Stream in Java can be defined as a sequence of elements from a source
    that supports aggregate operations on them. The source here refers to collections or
    arrays that provide data to a stream.

    A few important points about streams are:

        - A stream is not a data structure itself. It is a bunch of operations applied to a source. The source can be collections, arrays or I/O channels.
        - Streams don’t change the original data structure.
        - There can be zero or more intermediate operations that transform a stream into another stream.
        - Each intermediate operation is lazily executed (This will be discussed later).
        - Terminal operations produce the result of the stream.

    he Stream API defines a few interfaces such as Stream, IntStream, LongStream, etc.
        The Stream<T> interface is for object elements. For primitives, it defines IntStream, LongStream and DoubleStream interfaces.
        It is a good practice to use primitive streams if you are dealing with primitives because wrapping primitives to objects and auto-boxing is a costly process.
        Below is the complete list of methods defined in Stream API.

    Intermediate operations #
        These methods do not produce any results. They usually accept functional interfaces as parameters and always return a new stream. Some examples of intermediate operations are filter(), map(), etc.

    Terminal operations #
        These methods produce some results, e.g., count(), toArray(..), and collect(..).
        The streams operations can be further classified as:
        filtering
        slicing
        mapping
        matching and finding
        reduction
        collect

    Stream flatMap() method is used to flatten a stream of collections to a stream of elements combined from all collections.
    Basically, flatMap() is used to do following operation:
    Stream<String[]> -> flatMap -> Stream<String>
    Stream<Set<String>> -> flatMap -> Stream<String>
    Stream<List<String>> -> flatMap -> Stream<String>



     */
}

class StreamDemo {

    public static void main(String[] args)
    {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(p -> System.out.println(p));
    }
}

class StreamDemo2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Stream<String> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }
}
