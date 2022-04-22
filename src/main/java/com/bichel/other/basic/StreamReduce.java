package com.bichel.other.basic;

public class StreamReduce {
    /*

    Reduction stream operations are those operations which reduce the stream into a single value. The operations that we are going to discuss in this lesson are immutable operations because they reduce the result into a single-valued immutable variable. Given a collection of objects, we may need to get the sum of all the elements, the max element, or any other operation which gives us a single value as a result. This can be achieved through reduction operations.

    Before we discuss all the reduction operations in detail, let’s first look at some key concepts of reduction:

    Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty.

    Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream.

    Combiner – a function used to combine the partial result of the reduction operation when

    the reduction is parallelized.

    or there’s a mismatch between the types of the accumulator arguments and the types of the accumulator implementation.

     */
}
