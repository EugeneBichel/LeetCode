package com.bichel.leetcode.dp;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long[] arr;

  private static long fib(int n) {
    if (n <= 1)
      return n;

    if(arr[n] != 0)
      return arr[n];

    arr[n] = fib(n - 1) + fib(n - 2);

    return arr[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    arr = new long[n + 1];

    System.out.println(fib(n));
  }
}
