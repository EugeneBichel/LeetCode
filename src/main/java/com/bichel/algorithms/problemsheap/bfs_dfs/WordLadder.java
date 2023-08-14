package com.bichel.algorithms.problemsheap.bfs_dfs;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for(int i=0; i<size; i++) {
                String curWord = queue.poll();

                if(curWord.equals(endWord)) {
                    return level;
                }

                List<String> neighbors = neighbors(curWord);

                for(String neighbor: neighbors) {
                    if(words.contains(neighbor)) {
                        words.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return 0;
    }
    private List<String> neighbors(String curWord) {
        char[] chars = curWord.toCharArray();
        List<String> result = new ArrayList<>();

        for(int i=0; i<chars.length; i++) {
            char temp = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }

            chars[i] = temp;
        }

        return result;

    }
}
