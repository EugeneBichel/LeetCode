package com.bichel.algorithms;

/*
Given an array of integers citations where citations[i] is the number of citations
a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia:
The h-index is defined as the maximum value of h such
that the given researcher has published at least h papers that have each been
cited at least h times.

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total
and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each
and the remaining two with no more than 3 citations each, their h-index is 3.
 */

public class Hindex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        // counting papers for each citation number
        for (int c: citations) {
            papers[Math.min(n, c)]++;
        }

        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {
            k--;
        }

        return k;
    }
}