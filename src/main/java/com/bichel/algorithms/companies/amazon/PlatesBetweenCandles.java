package com.bichel.algorithms.companies.amazon;

import java.util.TreeMap;

/*
https://leetcode.com/problems/plates-between-candles/description/

id is 2055
 */
public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] nearestRightCandle = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] candleCount = new int[n];
        int[] ans = new int[queries.length];

        int candle = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestLeftCandle[i] = candle;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestRightCandle[i] = candle;
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                ++count;
            }
            candleCount[i] = count;
        }

        int idx = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            int leftCandle = nearestRightCandle[left];
            int rightCandle = nearestLeftCandle[right];

            int d = 0;
            if (leftCandle == -1 || rightCandle == -1) {
                ans[idx] = 0;
            } else {
                d = rightCandle - leftCandle;
                if (d > 1) {
                    ans[idx] = rightCandle - leftCandle + 1 -
                            (candleCount[rightCandle] - candleCount[leftCandle] + 1);
                } else {
                    ans[idx] = 0;
                }
            }

            ++idx;
        }

        return ans;
    }

    public int[] platesBetweenCandles2(String s, int[][] queries) {
        int n = s.length();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                map.put(i, index++);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer index1 = map.ceilingKey(queries[i][0]);
            Integer index2 = map.floorKey(queries[i][1]);
            if (index1 == null || index2 == null || index2 <= index1)
                continue;
            int place1 = map.get(index1);
            int place2 = map.get(index2);
            ans[i] = index2 - index1 - (place2 - place1);
        }
        return ans;
    }
}
