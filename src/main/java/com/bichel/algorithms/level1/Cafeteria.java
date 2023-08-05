package com.bichel.algorithms.level1;

/*
A cafeteria table consists of a row of NN seats, numbered from 11 to NN from left to right. Social distancing guidelines require that every diner be seated such that KK seats to their left and KK seats to their right (or all the remaining seats to that side if there are fewer than KK) remain empty.
There are currently MM diners seated at the table, the iith of whom is in seat S_iS
i
​
 . No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
Please take care to write a solution which runs within the time limit.
 */

import java.util.Arrays;

public class Cafeteria {
    /*
    N - number od seats
    K - number of seats between diners
    M - number of diners
    long[] S - array of taken seats
     */

    /*
    N = 15
    K = 2
    M = 3
    S = [11, 6, 14]

    Expected: 1
    1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
    0 0 0 - - 1 - - - - 1 - - 1 -
     */

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        //items are not sorted
        Arrays.sort(S);

        long result = 0;
        long start = 1;
        long end = 0;

        for (int i = 0; i < M; i++) {
            //the right border of the 1st dinner from the left
            end = S[i] - K - 1;
            result += getCount(start, end, K);
            //move the left border
            start = S[i] + K + 1;
        }

        //check the distance between the last right dinner and the end of the table
        result += getCount(start, N, K);
        return result;
    }

    private long getCount(long start, long end, long K) {
        return start > end ? 0 : (end - start) / (K + 1) + 1;
    }
}
