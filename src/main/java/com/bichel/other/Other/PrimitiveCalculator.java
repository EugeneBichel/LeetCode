package com.bichel.other.Other;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimalSequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }

        Collections.reverse(sequence);
        return sequence;
    }

    private static int[] resMinOne;
    private static int[] resDividedBy3;
    private static int[] resDividedBy2;

    private static List<Integer> dynamicProgrammingSeq(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        while (n >= 1) {

            if(n == 1) {
                sequence.add(n);
                return sequence;
            }

            if (n % 3 == 0) {
                sequence.add(n);
                n /= 3;
                if(resDividedBy3[n] == Integer.MAX_VALUE) {
                    List<Integer> temp = dynamicProgrammingSeq(n);
                    resDividedBy3[n] = temp.size();
                }
            }
/*
            if (n % 2 == 0) {
                sequence.add(n);
                n /= 2;
                if(resDividedBy2[n] == Integer.MAX_VALUE) {
                    List<Integer> temp = dynamicProgrammingSeq(n);
                    resDividedBy2[n] = temp.size();
                }
            }

            if(n > 1) {
                sequence.add(n);
                n -= 1;
                if(resMinOne[n] == Integer.MAX_VALUE) {
                    List<Integer> temp = dynamicProgrammingSeq(n);
                    resMinOne[n] = temp.size();
                }
            }
            */
        }

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        resMinOne = new int[n];
        resDividedBy2 = new int[n];
        resDividedBy3 = new int[n];

        for(int i = 0; i < n; i++) {
            resMinOne[i] = Integer.MAX_VALUE;
            resDividedBy2[i] = Integer.MAX_VALUE;
            resDividedBy3[i] = Integer.MAX_VALUE;
        }

        List<Integer> sequence = dynamicProgrammingSeq(n);

        System.out.println(sequence.size() - 1);

        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

