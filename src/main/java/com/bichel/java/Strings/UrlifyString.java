package com.bichel.java.Strings;

public class UrlifyString {
    public static void main(String[] args) {
        String inputStr = "Mr John Smith    ";
        String outputStr = urlify(inputStr.toCharArray(), 13);
        System.out.println(outputStr);
    }

    private static String urlify(final char[] str, final int trueLength) {

        final char whitespace = ' ';
        int whitespacesAmount = 0;

        for (int i = 0; i < trueLength; i++) {
            if (str[i] == whitespace) {
                whitespacesAmount++;
            }
        }

        int currIndex = trueLength + whitespacesAmount * 2 - 1;

        for (int i = trueLength - 1; currIndex >= 0; i--, currIndex--) {
            char currCh = str[i];

            if (str[i] == whitespace) {
                str[currIndex--] = '0';
                str[currIndex--] = '2';
                str[currIndex] = '%';
            } else {
                str[currIndex] = currCh;
            }
        }

        return String.valueOf(str);
    }
}
