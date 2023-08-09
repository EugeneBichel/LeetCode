package com.bichel.algorithms.problemsheap;
import java.util.*;

/*
Two strings are anagrams of each other if the letters of one string
can be rearranged to form the other string. Given a string,
find the number of pairs of substrings
of the string that are anagrams of each other.
 */

/*
The formula 𝑛(𝑛−1)/2 for the number of pairs you can form
from an 𝑛 element set has many derivations, even many on this site.

One is to imagine a room with 𝑛 people, each of whom shakes hands with everyone else.
If you focus on just one person you see that she participates in 𝑛−1 handshakes.
Since there are 𝑛 people, that would lead to 𝑛(𝑛−1) handshakes.

Note here that we are thinking about the multiplication 𝑥𝑦
as the total for 𝑥 groups of 𝑦 things, not as repeated addition.
Computationally they are the same, but psychologically they are different.

To finish the problem, we should realize that the total of 𝑛(𝑛−1)
counts every handshake twice, once for each of the two people involved.
So the number of handshakes is 𝑛(𝑛−1)/2.
 */

public class Anagrams {

    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String key = s.substring(i, j + 1);

                char[] temp = key.toCharArray();
                Arrays.sort(temp);
                key = new String(temp);

                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
        }

        int anagramPairs = 0;
        for (String k : map.keySet()) {
            int v = map.get(k);
            anagramPairs += v * (v - 1) / 2;
        }

        return anagramPairs;
    }
}
