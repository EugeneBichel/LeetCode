A Stream in Java can be defined as a sequence of elements from a source that supports aggregate operations on them. The source here refers to collections or arrays that provide data to a stream.

A few important points about streams are:
    - A stream is not a data structure itself. It is a bunch of operations applied to a source. The source can be collections, arrays or I/O channels.
    - Streams don’t change the original data structure.
    - There can be zero or more intermediate operations that transform a stream into another stream.
    - Each intermediate operation is lazily executed (This will be discussed later).
    - Terminal operations produce the result of the stream.

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
This was the basic introduction to streams. In the next few lessons, we will explore each of these operations. We will also look at how these methods are combined together to process collections.


Understanding flatMap() #
Stream flatMap() method is used to flatten a stream of collections to a stream of elements combined from all collections.

Basically, flatMap() is used to do following operation:
    Stream<String[]> -> flatMap -> Stream<String>
    Stream<Set<String>> -> flatMap -> Stream<String>
    Stream<List<String>> -> flatMap -> Stream<String>

Introduction to reduction operations #
Reduction stream operations are those operations which reduce the stream into a single value. The operations that we are going to discuss in this lesson are immutable operations because they reduce the result into a single-valued immutable variable. Given a collection of objects, we may need to get the sum of all the elements, the max element, or any other operation which gives us a single value as a result. This can be achieved through reduction operations.

Before we discuss all the reduction operations in detail, let’s first look at some key concepts of reduction:

Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty.

Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream.

Combiner – a function used to combine the partial result of the reduction operation when

the reduction is parallelized.

or there’s a mismatch between the types of the accumulator arguments and the types of the accumulator implementation.

