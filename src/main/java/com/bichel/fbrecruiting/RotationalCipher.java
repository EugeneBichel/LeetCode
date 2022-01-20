package com.bichel.fbrecruiting;

public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isAlphabetic(ch)) {
                if ((int) ch <= (int) 'Z') {
                    sb.append((char) (((int) ch - (int) 'A' + rotationFactor) % 26 + 'A'));
                } else
                    sb.append((char) (((int) ch - (int) 'a' + rotationFactor) % 26 + 'a'));
            } else if (Character.isDigit(ch)) {
                int num = (Character.getNumericValue(ch) + rotationFactor) % 10;
                sb.append(num);
            } else sb.append(ch);
        }

        return sb.toString();
    }
}
