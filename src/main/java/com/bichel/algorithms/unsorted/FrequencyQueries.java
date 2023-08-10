package com.bichel.algorithms.unsorted;

/*
You are given  queries. Each query is of the form two integers described below:
-  : Insert x in your data structure.
-  : Delete one occurence of y from your data structure, if present.
-  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

The queries are given in the form of a 2-D array  of size
where  contains the operation, and  contains the data element.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> mFreq = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        List<Integer> ans = new LinkedList<>();

        for (List<Integer> query : queries) {
            int key = query.get(0);
            int val = query.get(1);

            if (key == 1) {
                int f = 1;

                if (mFreq.containsKey(val)) {
                    f = mFreq.get(val);
                    freq.put(f, freq.getOrDefault(f, 1) - 1);
                    f = f + 1;
                }

                mFreq.put(val, f);
                freq.put(f, freq.getOrDefault(f, 0) + 1);

            } else if (key == 2) {
                if (mFreq.containsKey(val)) {
                    int f = mFreq.get(val);
                    int v = freq.getOrDefault(f, 0);

                    if (f > 1) {
                        freq.put(f, v - 1);
                        mFreq.put(val, f - 1);
                        v = freq.getOrDefault(f - 1, 0);
                        freq.put(f - 1, v + 1);
                    } else {
                        freq.put(f, v - 1);
                        mFreq.put(val, 0);
                    }
                }
            } else if (key == 3) {
                if (freq.containsKey(val) && freq.get(val) > 0) {
                    ans.add(1);
                } else {
                    ans.add(0);
                }
            }
        }

        return ans;
    }
}
