package com.bichel.other.GreedyAlgorithms;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here

        /*
        *
        * Task. The goal in this problem is to find the minimum number of coins needed to change the input value
(an integer) into coins with denominations 1, 5, and 10.
Input Format. The input consists of a single integer 𝑚.
Constraints. 1 ≤ 𝑚 ≤ 103
.
Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.
        *
        * */

        int num1 = 0;
        int num5 = 0;
        int num10 = 0;

        num10 = m / 10;

        m = m - num10 * 10;

        num5 = m / 5;

        m = m - num5 * 5;

        num1 = m;

        return num10 + num5 + num1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
