package com.bichel.algorithms.problemsheap.sort;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Integer[] arr = {2, 38, 27, 43, 3, 82, 9, 10, 4};

        //Selection.sort(arr);

        //Insertion.sort(arr);

        //MergeSort.sort(arr);

        //Shell.sort(arr);

        /*Stack<Integer> S = new Stack<Integer>();
        S.push(4);
        S.push(10);
        S.push(9);
        S.push(82);
        S.push(3);
        S.push(43);
        S.push(27);
        S.push(38);
        S.push(2);
        StackSort.sort(S);

        //Utility.print(arr);
        Utility.printStack(S);*/

        //QuickSort.sort(arr);

        //Bubble.sort(arr);

        int[] a = {2, 38, 27, 43, 3, 82, 9, 10, 4};
        int range = 100;
        a = Counting.sort(a, range);
        Utility.print(a);

        //Utility.print(arr);

        Scanner s = new Scanner(System.in);
        System.out.println(s.next());
    }
}
