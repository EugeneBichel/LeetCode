package com.bichel.fbrecruiting.warmup;

/*
There's a multiple-choice test with NN questions, numbered from 11 to NN. Each question has 22 answer options, labelled A and B. You know that the correct answer for the iith question is the iith character in the string CC, which is either "A" or "B", but you want to get a score of 00 on this test by answering every question incorrectly.
Your task is to implement the function getWrongAnswers(N, C) which returns a string with NN characters, the iith of which is the answer you should give for question ii in order to get it wrong (either "A" or "B").
Constraints
1 \le N \le 1001≤N≤100
C_i \in \{``A", ``B"\}C
i
​
 ∈{‘‘A",‘‘B"}
 */

public class AllWrong {
    public String getWrongAnswers(int N, String C) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char ch = C.charAt(i % C.length());
            if (ch == 'A') sb.append('B');
            else sb.append('A');
        }
        return sb.toString();
    }
}
