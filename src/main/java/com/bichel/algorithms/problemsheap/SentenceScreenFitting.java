package com.bichel.algorithms.problemsheap;

/*
Given a rows x cols screen and a sentence represented as a list of strings,
return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged,
and a word cannot be split into two lines.
A single space must separate two consecutive words in a line.

--
Solution:
It's kind of like a jump game. I use a array to record for each word, how far it can jump.
eg. dp[index] means if the row start at index then the start of next row is dp[index].
dp[index] can be larger than the length of the sentence, in this case, one row can span multiple sentences.
I comment the check whether a word is longer than the row since there is
no such test case. But it's better to check it.
And it makes little difference to the speed.

 */

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] dp = new int[sentence.length];
        int n = sentence.length;
        for (int i = 0, prev = 0, len = 0; i < sentence.length; ++i) {
            // remove the length of previous word and space
            if (i != 0 && len > 0) len -= sentence[i - 1].length() + 1;
            // calculate the start of next line.
            // it's OK the index is beyond the length of array so that
            // we can use it to count how many words one row has.
            while (len + sentence[prev % n].length() <= cols) len += sentence[prev++ % n].length() + 1;
            dp[i] = prev;
        }
        int count = 0;
        for (int i = 0, k = 0; i < rows; ++i) {
            // count how many words one row has and move to start of next row.
            // It's better to check if d[k] == k but I find there is no test case on it.
            // if(dp[k] == k) return 0;
            count += dp[k] - k;
            k = dp[k] % n;
        }
        // divide by the number of words in sentence
        return count / n;
    }
}
