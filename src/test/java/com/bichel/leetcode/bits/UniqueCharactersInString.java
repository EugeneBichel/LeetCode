package com.bichel.leetcode.bits;

import org.junit.jupiter.api.Test;

public class UniqueCharactersInString {
    @Test
    public void test() {
        //final String testStr = "qwerty";
        final String testStr = "qwq";
        boolean isUnique = isUniqueChars(testStr);
        System.out.println(isUnique);
    }

    private boolean isUniqueChars(final String str) {
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
