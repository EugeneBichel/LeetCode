package com.bichel.leetcode.bits;

import org.junit.jupiter.api.Test;

/**
 * >> is arithmetic shift right, >>> is logical shift right.

 In an arithmetic shift, the sign bit is extended to preserve the
 signedness of the number.

 For example: -2 represented in 8 bits would be 11111110
 (because the most significant bit has negative weight).
 Shifting it right one bit using arithmetic shift would give you 11111111,
 or -1. Logical right shift, however, does not care that the value could
 possibly represent a signed number; it simply moves everything to the
 right and fills in from the left with 0s. Shifting our -2 right one bit
 using logical shift would give 01111111
 */

public class ShiftRightAndLogicalShifting {
    @Test
    public void test() {
        //Arrays.sort(new int[]{1, 2, 3, 4});

        int itemsNumber = 8;
        int logicalShiftRight = itemsNumber >>> 1;
        int arithmeticShiftRight = itemsNumber >> 1;

        System.out.println("Items number is " + itemsNumber);
        System.out.println(logicalShiftRight); //4
        System. out.println(arithmeticShiftRight);

        itemsNumber = -8;
        logicalShiftRight = itemsNumber >>> 1;
        arithmeticShiftRight = itemsNumber >> 1;

        System.out.println("Items number is " + itemsNumber);
        System.out.println(logicalShiftRight); //4
        System. out.println(arithmeticShiftRight);
    }
}
