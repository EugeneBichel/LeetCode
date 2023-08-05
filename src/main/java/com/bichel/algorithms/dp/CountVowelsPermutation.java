package com.bichel.algorithms.dp;

import java.util.Arrays;

/*
Given an integer n,
your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3:
Input: n = 5
Output: 68

Constraints
1 <= n <= 2 * 10^4

 */

public class CountVowelsPermutation {
    static int solution1(int n) {

        //each letter has n permutations
        //5 letters have n*5 permutations

        //each letter has n permutations
        long[] aPerm = new long[n];
        long[] ePerm = new long[n];
        long[] iPerm = new long[n];
        long[] oPerm = new long[n];
        long[] uPerm = new long[n];

        //init each has 1
        aPerm[0] = 1l;
        ePerm[0] = 1l;
        iPerm[0] = 1l;
        oPerm[0] = 1l;
        uPerm[0] = 1l;

        int mod = 1000000007;

        //starts from 2d
        for(int k = 1; k < n; k++ ) {
            aPerm[k] = (ePerm[k-1] + iPerm[k-1] + uPerm[k-1]) % mod;
            ePerm[k] = (aPerm[k-1] + iPerm[k-1]) % mod;
            iPerm[k] = (ePerm[k-1] + oPerm[k-1]) % mod;
            oPerm[k] = iPerm[k-1] % mod;
            uPerm[k] = (iPerm[k-1] + oPerm[k-1]) % mod;
        }

        long sum = (aPerm[n-1] + ePerm[n-1] + iPerm[n-1] + oPerm[n-1] + uPerm[n-1]) % mod;

        return (int)sum;
    }


    static int doCountVowelsPermutation(int lengthOfWord) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        final double numberOfPermutations = Math.pow(vowels.length, lengthOfWord);

        //List<String> words = new ArrayList<>(Double.valueOf(numberOfPermutations).intValue());

        char[] temp = new char[lengthOfWord];
        Arrays.fill(temp, '0');
        long amount = 0l;

        for (int i = 0; i < numberOfPermutations; i++) {
            int n = i;
            for (int k = 0; k < lengthOfWord; k++) {
                temp[k] = vowels[n % vowels.length];
                n /= vowels.length;
            }

            String word = String.valueOf(temp);

            if(validated(word)) {
                amount++;
                //words.add(word);
            }
        }

       // words.forEach(word -> System.out.print(word + "; "));

        return Double.valueOf(amount % (Math.pow(10, 9) + 7)).intValue();
    }
    static boolean validated(String word) {

        char[] chars = word.toCharArray();

        for(int i = 0; i < chars.length-1; i++ ) {
            if(chars[i] == 'a' && chars[i+1] != 'e') {
                return false;
            }
            if(chars[i] == 'e') {
                if( chars[i+1] != 'a' && chars[i+1] != 'i') {
                    return false;
                }
            }
            if(chars[i] == 'i') {
                if(chars[i+1] == 'i') {
                    return false;
                }
            }
            if(chars[i] == 'o') {
                if( chars[i+1] != 'i' && chars[i+1] != 'u') {
                    return false;
                }
            }
            if(chars[i] == 'u' && chars[i+1] != 'a') {
                return false;
            }
        }

        return true;
    }
}
