package com.bichel.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length == 0) return 0;
        if(chars.length == 1) {
            return 1;
        }

        List<Character> out = new ArrayList<>();

        int num = 1;
        for(int i=1; i<chars.length; i++) {
            if(chars[i-1] == chars[i]) {
                num++;
            }
            if(i == chars.length-1 || chars[i-1] != chars[i]) {

                out.add(chars[i-1]);

                if(num > 1) {
                    char[] digits = String.valueOf(num).toCharArray();
                    int k = 0;
                    while(k < digits.length) {
                        out.add(digits[k++]);
                    }
                }

                num = 1;
            }
        }

        if(chars[chars.length-1] != chars[chars.length-2]) out.add(chars[chars.length-1]);

        for(int i=0; i<out.size(); i++) {
            chars[i] = out.get(i);
        }

        return out.size();
    }
}
