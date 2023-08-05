package com.bichel.algorithms.math;

public class AddStrings {
    public String sum(String val1, String val2) {

        char[] ch1 = val1.toCharArray();
        char[] ch2 = val2.toCharArray();
        char[] ch21 = ch2;
        char[] ch11 = ch1;

        if(ch1.length > ch2.length) {
            int n = ch1.length - ch2.length;
            ch21 = new char[ch1.length];

            for(int i=0;i<ch1.length;i++) {
                ch21[i]='0';
            }
            for(int i=n;i<ch1.length;i++) {
                ch21[i]=ch2[i-n];
            }

        } else if(ch2.length > ch1.length) {
            int n = ch2.length - ch1.length;
            ch11 = new char[ch2.length];

            for(int i=0;i<ch2.length;i++) {
                ch11[i]='0';
            }
            for(int i=n;i<ch2.length;i++) {
                ch11[i]=ch1[i-n];
            }
        }

        char[] res = new char[ch11.length+1];

        int nextD = 0;
        for(int i = ch11.length-1; i >= 0; i--) {

            int arg1 = ch11[i] - '0';
            int arg2 = ch21[i] - '0';
            int sum = arg1+arg2 + nextD;

            if(sum > 9) {
                nextD = 1;
                sum -=10;
            } else {
                nextD = 0;
            }

            res[i+1] = (char)(sum + '0');

            if(i == 0 && nextD == 1) {
                res[i] = (char)(nextD + '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: res) {

            if(Character.isDigit(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
