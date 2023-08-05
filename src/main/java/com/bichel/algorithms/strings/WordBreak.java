package com.bichel.algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict,
return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return bfs(s, wordDict);
    }

    private boolean useDynamicProgramming(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean bfs(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);

                    if (end == s.length()) {
                        return true;
                    }
                }
            }

            visited[start] = true;
        }

        return false;
    }

    /*
    we can see that many subproblems were redundant, i.e we were calling the recursive function
    multiple times for a particular string. To avoid this we can use memoization method,
    where an array memomemo is used to store the result of the subproblems.
    Now, when the function is called again for a particular string,
    value will be fetched and returned using the memomemo array,
    if its value has been already evaluated.

    With memoization many redundant subproblems are avoided and recursion
    tree is pruned and thus it reduces the time complexity by a large factor.
     */
    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length())
            return true;

        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) &&
                    wordBreakMemo(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }

        memo[start] = false;
        return memo[start];
    }

    /*
    The naive approach to solve this problem is to use recursion and backtracking.
    For finding the solution, we check every possible prefix of that string
    in the dictionary of words, if it is found in the dictionary,
    then the recursive function is called for the remaining portion of that string.
    And, if in some function call it is found that the complete string is in dictionary,
    then it will return true.
     */
    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length())
            return true;

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) &&
                    wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }

        return false;
    }
}
