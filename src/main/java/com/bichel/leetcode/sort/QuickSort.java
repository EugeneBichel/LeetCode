package com.bichel.leetcode.sort;

/*
1. First, it selects a value from the list, which serves as a pivot value to divide the list
into two sublists. One sublist contains all the values that are less than the pivot value,
while the other sublist contains the values that are greater than or equal to the pivot value.
This process is also called partitioning. The strategy of choosing a pivot value can vary.
Typically, one can choose the first element in the list as the pivot,
or randomly pick an element from the list.

2. After the partitioning process, the original list is then reduced into two smaller sublists.
We then recursively sort the two sublists.

3. After the partitioning process, we are sure that all elements in one sublist are less or equal
than any element in another sublist. Therefore, we can simply concatenate the two sorted sublists
that we obtain in step [2] to obtain the final sorted list.

time complexity O(NlogN)

1. int[] arr
index: 0 1 2 3 4 5 6 7
value: 1 5 3 2 8 7 6 4
pivot = 4 - the highest element
i = 0, j = 0

2. arr[j] < pivot -> arr[0] < pivot -> 1 < 4 true
   - swap arr[j] and arr[i]
index: 0 1 2 3 4 5 6 7
value: 1 5 3 2 8 7 6 4
pivot = 4 - the highest element
i = 0, j = 0
    i++
    j++
i = 1, j = 1

3. arr[j] > pivot -> arr[1] > pivot -> 5 < 4 false
    j++
i = 1, j = 2

4.  arr[j] < pivot -> arr[2] < pivot -> 3 < 4 true
   - swap arr[j] and arr[i]
   - swap arr[2] and arr[1]
index: 0 1 2 3 4 5 6 7
value: 1 3 5 2 8 7 6 4
pivot = 4 - the highest element
i = 1, j = 2
    i++
    j++
i = 2, j = 3

5.  arr[j] < pivot -> arr[3] < pivot -> 2 < 4 true
   - swap arr[j] and arr[i]
   - swap arr[3] and arr[2]
index: 0 1 2 3 4 5 6 7
value: 1 3 2 5 8 7 6 4
pivot = 4 - the highest element
i = 2, j = 3
    i++
    j++
i = 3, j = 4

6.  arr[j] < pivot -> arr[4] < pivot -> 8 < 4 false
pivot = 4 - the highest element
i = 3, j = 4
    j++
i = 3, j = 5

7.  arr[j] < pivot -> arr[5] < pivot -> 7 < 4 false
pivot = 4 - the highest element
i = 3, j = 5
    j++
i = 3, j = 6

8.  arr[j] < pivot -> arr[6] < pivot -> 6 < 4 false
pivot = 4 - the highest element
i = 3, j = 6
    j++
i = 3, j = 7

8.  swap pivot with arr[i]
i = 3, j = 7

pivot = 4 - the highest element
index: 0 1 2 3 4 5 6 7
value: 1 3 2 5 8 7 6 4

swap

index: 0 1 2 3 4 5 6 7
value: 1 3 2 4 8 7 6 5

i=3
9. return i
 */

public class QuickSort {
    public void quickSort(int[] lst) {
        /* Sorts an array in the ascending order in O(n log n) time */
        int n = lst.length;
        quickSort(lst, 0, n - 1);
    }

    private void quickSort(int[] lst, int lo, int hi) {
        if (lo < hi) {
            int p = partition(lst, lo, hi);
            quickSort(lst, lo, p - 1);
            quickSort(lst, p + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
    /*
      Picks the last element hi as a pivot
      and returns the index of pivot value in the sorted array */
        int pivot = arr[hi];
        int i = lo;

        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }

        int tmp = arr[i];
        arr[i] = arr[hi];
        arr[hi] = tmp;

        return i;
    }
}
