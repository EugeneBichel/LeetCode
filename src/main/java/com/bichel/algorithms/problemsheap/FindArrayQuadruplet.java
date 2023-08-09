package com.bichel.algorithms.problemsheap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an unsorted array of integers arr and a number s,
write a function findArrayQuadruplet that finds four numbers (quadruplet)
in arr that sum up to s. Your function should return an array of these numbers
in an ascending order. If such a quadruplet doesn’t exist, return an empty array.
Note that there may be more than one quadruplet in arr whose sum is s.
You’re asked to return the first one you encounter (considering the results are sorted).
Explain and code the most efficient solution possible,
and analyze its time and space complexities.

Example:
input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20

output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
                     # whose sum is 20. Notice that there
                     # are two other quadruplets whose sum is 20:
                     # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
                     # asked to return the just one quadruplet (in an
                     # ascending order)
 */

public class FindArrayQuadruplet {
    static class Pair2 {
        int ind1;
        int ind2;

        public Pair2(int ind1, int ind2) {
            this.ind1 = ind1;
            this.ind2 = ind2;
        }
    }

    static int[] findArrayQuadruplet(int[] arr, int s) {

        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Pair2> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                m.put(arr[i] + arr[j], new Pair2(i, j));
            }
        }

        int[] ans = new int[4];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (m.containsKey(s - sum)) {
                    Pair2 p = m.get(s - sum);
                    if (i != j && p.ind1 != i && p.ind1 != j &&
                            p.ind2 != i && p.ind2 != j) {


                        ans[0] = arr[i];
                        ans[1] = arr[j];
                        ans[2] = arr[p.ind1];
                        ans[3] = arr[p.ind2];
                        Arrays.sort(ans);

                        return ans;

                    }
                }
            }
        }

        return new int[0];

    }

    //better
    /*

    function findArrayQuadruplet(arr, s):
    n = arr.length

    # if there are fewer than 4 items in arr, by
    # definition no quadruplet exists whose sum is s
    if (n < 4):
        return []

    # sort arr in an ascending order
    arr.sort()

    for i from 0 to n - 4:
        for j from i + 1 to n - 3:
            # r stores the complementing sum
            r = s - (arr[i] + arr[j])

            # check for sum r in subarray arr[j+1…n-1]
            low = j + 1, high = n - 1;

            while (low < high):
                if (arr[low] + arr[high] < r):
                    low++

                else if (arr[low] + arr[high] > r):
                    high--

                # quadruplet with given sum found
                else:
                    return [arr[i], arr[j], arr[low], arr[high]]

    return []

     */
}
