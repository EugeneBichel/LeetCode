package com.bichel.facebook;

import java.util.Arrays;

/*
Given an array of points where points[i] = [xi, yi]
represents a point on the X-Y plane and an integer k,
return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is
the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order.
The answer is guaranteed to be unique (except for the order that it is in).
 */

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }

    private int[][] quickSelect(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                left = pivotIndex;
            } else {
                right = pivotIndex - 1;
            }
        }

        return Arrays.copyOf(points, k);
    }
    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[left + (right - left) / 2];
        int pivotDist = pivot[0] * pivot[0] + pivot[1] * pivot[1];

        while (left < right) {
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                right--;
            } else {
                left++;
            }
        }

        // Ensure the left pointer is just past the end of
        // the left range then return it as the new pivotIndex
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }
    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest2(int[][] points, int k) {

        Arrays.sort(points, (int[] a, int[] b) -> {
            double d1 = Math.sqrt((a[0] * a[0] + a[1] * a[1]));
            double d2 = Math.sqrt((b[0] * b[0] + b[1] * b[1]));

            return Double.compare(d1, d2);
        });

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;
    }
}
