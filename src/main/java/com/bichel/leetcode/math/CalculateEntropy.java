package com.bichel.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class CalculateEntropy {
    public double calculateEntropy(int[] input) {

        int N = input.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<input.length; i++) {
            m.put(input[i], m.getOrDefault(input[i], 0)+1);
        }

        double ans = 0;

        for(Integer key: m.keySet()) {
            double probability = (double)m.get(key) / N;
            ans -=probability * (Math.log(probability)/Math.log(2));
        }

        return ans;
    }
}
