package com.bichel.fbrecruiting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.IntStream.*;

public class MinimizingPermutations {

    int minOperations(int[] arr) {
        int ret = 0;

        int[] target = rangeClosed(1, arr.length).toArray();

        Set<String> seen = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(arr);
        seen.add(Arrays.toString(arr));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (Arrays.equals(target, curr)) {
                    return ret;
                }

                for (int j = 0; j < curr.length; j++) {
                    for (int k = j + 1; k < curr.length; k++) {
                        int[] next = curr.clone();
                        reverse(next, j, k);

                        if (!seen.contains(Arrays.toString(next))) {
                            queue.offer(next);
                            seen.add(Arrays.toString(next));
                        }
                    }
                }
            }
            ret++;
        }
        return ret;
    }

    private void reverse(int[] arr, int from, int to) {
        for (; from < to; from++, to--) {
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }
}
