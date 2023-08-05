package com.bichel.java.Strings;

public class PalindromePermutation {
    public static void main(String[] args) {

        /**
         * A palindrome is a string that is the same forwards and backwards.
         * A permutation is a rearrangement of letters.
         *
         * What does it take to be able to write a set of characters the same way forwards and backwards?
         * We need to have an even number of almost all characters, so that half can be on one side and
         * half can be on the other side. At most one character (the middle character) can have an odd count.
         *
         * For example, we know tactcoapapa is a permutation of a palindrome because it has 2 Ts, 4 As,
         * 2 Cs, 2Ps and 1 O. That O would be the center of all possible palindromes.
         *
         * So rules for palindromes:
         * 1. Strings with even length must have all even counts of characters
         * 2. Strings of an odd length must have exactly one character with an odd count
         * 3. An "even" string can't have an odd number of exactly one character
         */

        final String inputStr = "Tact Coa";

    }

    private static boolean isPermutationOfPalindrome(String phrase) {
        return false;
    }
}
