package com.bichel.algorithms.strings;

import java.util.List;
import java.util.ArrayList;

public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        List<Integer> nums = new ArrayList<>();

        int ind = 0;
        for(Character ch:s.toCharArray()) {

            int num = ch - 'a' + 1;
            while(num >= 1) {
                int digit = num % 10;
                num /= 10;
                nums.add(digit);
            }
        }

        int sum = 0;

        for(int i=0; i< nums.size(); i++) {
            sum+=nums.get(i);
        }

        k-=1;

        while(k>0) {
            int temp = 0;
            while(sum >= 1) {
                int digit = sum % 10;
                sum /= 10;
                temp += digit;
            }

            sum = temp;
            k-=1;
        }

        return sum;
    }
}
