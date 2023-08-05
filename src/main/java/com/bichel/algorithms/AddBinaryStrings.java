package com.bichel.algorithms;

public class AddBinaryStrings {
    public String addBinary2(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n < m)
            return addBinary2(b, a);

        int L = Math.max(n, m);

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = m - 1;

        for (int i = L - 1; i >= 0; i--) {
            if (a.charAt(i) == '1')
                carry++;

            if (j >= 0 && b.charAt(j--) == '1')
                carry++;

            if (carry % 2 == 1)
                sb.append('1');
            else
                sb.append('0');

            carry /= 2;
        }

        if (carry == 1)
            sb.append('1');

        return sb.reverse().toString();
    }

    public String addBinary(String a, String b) {
        int size = Math.max(a.length(), b.length());

        if (a.length() < size) {
            StringBuilder sb = new StringBuilder();
            char[] zeros = new char[size - a.length()];
            for (int i = 0; i < size - a.length(); i++) {
                zeros[i] = '0';
            }
            sb.append(zeros).append(a);
            a = sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            char[] zeros = new char[size - b.length()];
            for (int i = 0; i < size - b.length(); i++) {
                zeros[i] = '0';
            }
            sb.append(zeros).append(b);
            b = sb.toString();
        }

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        int index = c1.length - 1;
        StringBuilder res = new StringBuilder();
        int extra = 0;

        while (index >= 0) {
            int v1 = (int) (c1[index] - 48);
            int v2 = (int) (c2[index] - 48);

            int sum = v1 + v2 + extra;

            if (sum == 2) {
                extra = 1;
                sum = 0;
            } else if (sum == 3) {
                extra = 1;
                sum = 1;
            } else {
                extra = 0;
            }

            res.append((char) (sum + '0'));
            index--;
        }

        if (extra == 1) {
            res.append('1');
        }

        return res.reverse().toString();
    }
}
