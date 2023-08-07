package com.bichel.java.basic;

public class StringPoolTest {
    public static void main(String[] args) {
        String one = "one";
        String two = "one";

        System.out.println(one.equals(two));
        System.out.println(one == two);

        Integer i = 3;
        String iThree = i.toString();
        String three = "3";

        System.out.println(iThree.equals(three));
        System.out.println(iThree == three);

        Integer x = 4;
        String xFour = x.toString().intern();
        String four = "4";

        System.out.println(xFour.equals(four));
        System.out.println(xFour == four);
    }
}
