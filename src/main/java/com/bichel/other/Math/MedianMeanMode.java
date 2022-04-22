package com.bichel.other.Math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class MedianMeanMode {
    public static void main(String[] args) {
        String[] inputNumbers = "64630 11735 14216 99233 14470 4978 73429 38120 51135 67060".split(" ");
        int N = 10;
        //int N = Integer.valueOf(args[0]);
        //String[] inputNumbers = args[1].split(" ");
        List<Double> arr = new ArrayList<>();

        BigDecimal mean = BigDecimal.ZERO;
        Arrays.stream(inputNumbers).forEach(num -> arr.add(Double.valueOf(num)));
        int[] arrInt = new int[N];

        for(int i = 0; i < N; i++) {
            arrInt[i] = Integer.valueOf(inputNumbers[i]).intValue();
        }

        Arrays.sort(arrInt);
        int maxValue = arrInt[N-1];
        int[] arrRes = new int[maxValue+1];

        for(int i = 0; i < N; i++) {
            arrRes[arrInt[i]]++;
        }

        Double sum = arr.stream().reduce((res, value) -> res + value).get();
        mean = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf((long) N));

        System.out.printf("%.1f%n",mean);

        int index1 = N/2;
        int index2 = index1 - 1;

        Collections.sort(arr);

        BigDecimal median = (BigDecimal.valueOf(arr.get(index1) + arr.get(index2))).divide(BigDecimal.valueOf(2));

        System.out.printf("%.1f%n", median);

        int maxV = Arrays.stream(arrRes).max().getAsInt();

        List<Integer> modes = new ArrayList<>();
        for(int i = arrRes.length - 1; i >= 0; i--) {
            if(arrRes[i] == maxV) {
                modes.add(i);
            }
        }

        Collections.sort(modes);

        System.out.println(modes.get(0));
    }
}
