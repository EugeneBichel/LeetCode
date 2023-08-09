package com.bichel.algorithms.problemsheap.dp;

public class Fibonacci {
  private static long[] arr;

  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long fib(int n) {
    if (n <= 1)
      return n;

    if (arr[n] != 0)
      return arr[n];

    arr[n] = fib(n - 1) + fib(n - 2);

    return arr[n];
  }
}
