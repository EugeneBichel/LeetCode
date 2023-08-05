package com.bichel.algorithms;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {

    long abProduct = a * b;

    for (long lcm = 1; lcm < abProduct; lcm++) {
      if (lcm % a == 0 && lcm % b == 0) {
        return lcm;
      }
    }

    return abProduct;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
