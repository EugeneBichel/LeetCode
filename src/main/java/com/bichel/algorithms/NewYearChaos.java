package com.bichel.algorithms;
/**
* It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
 * There are a number of people queued up, and each person wears a sticker indicating
 * their initial position in the queue. Initial positions increment by  from
 * at the front of the line to  at the back.
Any person in the queue can bribe the person directly in front of them to swap positions.
 If two people swap positions, they still wear the same sticker denoting
 their original places in line. One person can bribe at most two others.
 For example, if  and bribes , the queue will look like this: .
Fascinated by this chaotic queue, you decide you must know the minimum number
 of bribes that took place to get the queue into its current state!
* */

import java.util.*;

public class NewYearChaos {

    static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

    static int indexOf(int[] q, int item) {
        for(int i = 0; i < q.length; i++) {
            if(q[i] == item) {
                return i;
            }
        }

        return -1;
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        final int N = q.length;
        int brubesN = 0;

        for(int item = N; item >= 1; item--) {
            int i = indexOf(q, item);

                /*if(i-2 >= 0 && q[i-2] > q[i]) {
                    swap(q, i, i-1);
                    swap(q, i-1, i-2);
                    brubesN+=2;
                } else if(i-1 >= 0 && q[i] < q[i-1]) {
                    swap(q, i, i-1);
                    brubesN++;
                }else */if(i+2 < N && q[i] > q[i+2]) {
                swap(q, i, i+1);
                swap(q, i+1, i+2);
                brubesN+=2;
            } else if(i+1 < N && q[i] > q[i+1]) {
                swap(q, i, i+1);
                brubesN++;
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = i-1; j >=0; j--) {
                if(q[j] > q[i]) {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(brubesN);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
