package com.bichel.leetcode.bit;

public class UniqueCharactersInString {
    public static void main(String[] args) {
        //final String testStr = "qwerty";
        final String testStr = "qwq";
        boolean isUnique = isUniqueChars(testStr);
        System.out.println(isUnique);
    }

    private static boolean isUniqueChars(final String str) {
        int checker = 0;

        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';

            int leftShiftedVal = 1 << val; // 2 to val power. If val = 16, then leftShiftedVal = 2^16 = 65536
            int bitwiseAndRes = checker & leftShiftedVal;

            if(bitwiseAndRes > 0) {
                return false;
            }

            checker |= leftShiftedVal;
        }

        return true;
    }
}
