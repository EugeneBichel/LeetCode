package com.bichel.other.basic;

/*
There are two ways in which we can create a parallel Stream:

Using the parallelStream() method.
Or, if we already have a stream, we can use the parallel() method to convert it into a parallel stream.
 */

import java.util.stream.Stream;

public class ParallelStreamTest {

    public static void main(String args[]) {
        System.out.println("------------------------------- Serial Stream  ---------------------------------");
        Stream.of(1, 2, 3, 4, 5, 6, 7)
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));


        System.out.println("-------------------------------- Parallel Stream -----------------------------");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
                .parallel()
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
    }
}

/*
The parallel stream is fast but does this mean we should always create a parallel stream? Are there any situations where we should not use a parallel stream?

The answer is yes.

A parallel stream has a lot of overhead compared to a sequential one. Coordinating the threads takes a significant amount of time. We should always use serial stream and consider using a parallel Stream in the following cases:

We have a large amount of data to process.
We already have a performance problem in the first place.
All the shared resources between threads need to be synchronized properly otherwise it might produce unexpected results.
 */

/*
According to Brian Goetz (Java Language Architect & specification lead for Lambda Expressions), the following things should be considered before going for parallelization:

Splitting is not more expensive than doing the work.

Task dispatch or management costs between the threads is not too high.

The result combination cost must not be too high.

Use the NQ formula to decide if you want to use parallelism.

NQ Model:

N x Q > 10000

where,
N = number of data items
Q = amount of work per item
 */