package com.bichel.algorithms.strings;

/*
order and str are strings composed of lowercase letters.
In order, no letter occurs more than once.
order was sorted in some custom order previously.
We want to permute the characters of str so that they match
the order that order was sorted.

More specifically, if x occurs before y in order,
then x should occur before y in the returned string.

Return any permutation of str (as a string) that satisfies this property.

Example:
Input:
order = "cba"
str = "abcd"

Output: "cbad"

Explanation:
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in order, it can be at any position in the returned string.
"dcba", "cdba", "cbda" are also valid outputs.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String str) {
        char[] sorted = new char[str.length()];

        Arrays.fill(sorted, ' ');
        char[] source = str.toCharArray();

        //a map with number of symbols in string
        Map<Character, Integer> appears = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            appears.put(ch, appears.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> alphabet = new HashMap<>();
        int ind = 0;
        for (Character ch : order.toCharArray()) {
            alphabet.put(ch, ind);
            if (appears.containsKey(ch)) {
                ind += appears.get(ch);
            } else {
                ind++;
            }
        }

        int unsorted = 1;

        for (int i = 0; i < source.length; i++) {
            if (alphabet.containsKey(source[i])) {
                ind = alphabet.get(source[i]);
                if (sorted[ind] == ' ') {
                    sorted[ind] = source[i];
                } else {
                    while (sorted[ind] != ' ')
                        ind++;

                    sorted[ind] = source[i];
                }
            } else {
                sorted[source.length - unsorted++] = source[i];
            }
        }

        return new String(sorted);
    }
}
