package com.bichel.algorithms.unsorted;

import java.util.HashMap;
import java.util.Map;

public class sacks {
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int item: ar) {
            if(map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }


        int pairsAmount = 0;

        for(int sackNumber: map.values()) {
            pairsAmount += sackNumber / 2;
        }

        return pairsAmount;
    }
}
