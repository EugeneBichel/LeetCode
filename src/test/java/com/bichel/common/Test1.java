package com.bichel.common;

public class Test1 {
    public static void main(String [] args)
    {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        if ( b1 & b2 | b2 & b3 | b2 ) /* Line 8 */
            System.out.print("ok ");
        if ( b1 & b2 | b2 & b3 | b2 | b1 ) /*Line 10*/
            System.out.println("dokey");

        System.out.println(10 + Math.random()*41);

        System.out.println(2 * 2 - 3 > 2 && 4 - 2 > 5);
        System.out.println(2 * 2 - 3 > 2 || 4 - 2 > 5);
    }


}