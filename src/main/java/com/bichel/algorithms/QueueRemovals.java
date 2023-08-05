package com.bichel.algorithms;

public class QueueRemovals {
    public int[] findPositions(int[] arr, int x) {
        x = Math.min(x, arr.length);
        int[] result = new int[x];
        int max, maxPos = 0;

        int start = 0;
        int readCount = 0;

        for (int i = 0; i < x; i++) {
            readCount = Math.min(x, arr.length - i);
            maxPos = start;
            max = arr[maxPos];

            while (readCount > 0) {
                if (arr[start] != -1) {
                    if (max < arr[start]) {
                        max = arr[start];
                        maxPos = start;
                    }
                    if (arr[start] > 0) {
                        arr[start] = arr[start] - 1;
                    }
                    readCount--;
                }

                start++;
                start = start % arr.length;
            }

            arr[maxPos] = -1;
            result[i] = maxPos + 1;
        }

        return result;
    }
}
