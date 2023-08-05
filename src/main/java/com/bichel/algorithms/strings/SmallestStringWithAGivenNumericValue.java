package com.bichel.algorithms.strings;

/*
Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27,
and it is the smallest string with such a value and length equal to 3.
 */

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];

        for (int position = 0; position < n; position++) {
            int positionsLeft = (n - position - 1);
            if (k > positionsLeft * 26) {
                int add = k - (positionsLeft * 26);
                result[position] = (char) ('a' + add - 1);
                k -= add;
            } else {
                result[position] = 'a';
                k--;
            }
        }
        return new String(result);
    }
}
