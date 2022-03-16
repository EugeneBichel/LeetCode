package com.bichel.facebook;

/*
Given a string num which represents an integer,
return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees
(looked at upside down).
 */

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        // Note that using a String here and appending to it would be
        // poor programming practice.
        StringBuilder rotatedStringBuilder = new StringBuilder();

        // Remember that we want to loop backwards through the string
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' || c == '1' || c == '8') {
                rotatedStringBuilder.append(c);
            } else if (c == '6') {
                rotatedStringBuilder.append('9');
            } else if (c == '9') {
                rotatedStringBuilder.append('6');
            } else { // This must be an invalid digit.
                return false;
            }
        }

        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }
}
