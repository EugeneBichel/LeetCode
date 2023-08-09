package com.bichel.algorithms.problemsheap.strings;

/*
There's a multiple-choice test with N questions, numbered from 1 to N.
Each question has 22 answer options, labelled A and B.
You know that the correct answer
for the ith question is the ith character in the string C,
which is either "A" or "B", but you want to get a score of 0
on this test by answering every question incorrectly.

Your task is to implement the function getWrongAnswers(N, C)
which returns a string with N characters, the ith of
which is the answer you should give for question i in order to get it wrong
(either "A" or "B").
 */

public class AllWrong {
    public String getWrongAnswers(int N, String C) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char ch = C.charAt(i % C.length());
            if (ch == 'A') {
                sb.append('B');
            } else {
                sb.append('A');
            }
        }

        return sb.toString();
    }
}
