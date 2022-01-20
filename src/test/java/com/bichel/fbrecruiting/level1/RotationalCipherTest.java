package com.bichel.fbrecruiting.level1;

import org.junit.jupiter.api.Test;

public class RotationalCipherTest {
    @Test
    public void test1() {
        int rotationFactor = 3;
        char ch = 'E'; // a b c d e f g
        System.out.println((int)'A');
        System.out.println((int)ch);
        System.out.println((int)'Z');
        char ch2 = (char)(((int)ch + rotationFactor) % 25 + 'A');
        char ch3 = (char)(((int)ch + rotationFactor) % 25 + 'a');
        System.out.println(ch3);
        System.out.println(ch2);

        //char n = '9';
        //int num = (Character.getNumericValue(n) + rotationFactor) % 10;
        //System.out.println(num);
    }
}
