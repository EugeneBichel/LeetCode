package com.bichel.algorithms.companies.amazon;

/*
You are given a 0-indexed integer array nums and a positive integer k.

We call an index i k-big if the following conditions are satisfied:

There exist at least k different indices idx1 such that idx1 < i and nums[idx1] < nums[i].
There exist at least k different indices idx2 such that idx2 > i and nums[idx2] < nums[i].
Return the number of k-big indices.
 */

//FenwichTree
public class CountTheNumberOfKBigIndices {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        BIT bitL = new BIT(n + 1);
        BIT bitR = new BIT(n + 1);
        int[][] count = new int[n][2];
        for (int i = 0; i < n; i++) {
            count[i][0] = bitL.query(nums[i] - 1);
            bitL.update(nums[i], 1);

            count[n - i - 1][1] = bitR.query(nums[n - i - 1] - 1);
            bitR.update(nums[n - i - 1], 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) if (count[i][0] >= k && count[i][1] >= k) res++;
        return res;
    }

    class BIT {
        int[] arr;
        int lgn;

        BIT(int n) {
            arr = new int[n + 1];
            lgn = (int) (Math.log(n + 1) / Math.log(2)) + 1;
        }

        void update(int index, int diff) {
            index++;
            while (index < arr.length) {
                arr[index] += diff;
                index += index & (-index);
            }
        }

        int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += arr[index];
                index -= index & (-index);
            }
            return sum;
        }
    }
}
