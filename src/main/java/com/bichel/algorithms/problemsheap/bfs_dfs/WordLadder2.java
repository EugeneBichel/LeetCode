package com.bichel.algorithms.problemsheap.bfs_dfs;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].



Example 1:
Input: beginWord = "hit", endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */

/*
- BFS
- DFS
- graph algorithms
 */

/*
goal: find all possible shortest transformation sequence.

begin word: hit
end word: cog

hit -> hot -> dot -> dog -> cog
         -> lot -> log ->

possible shortest path:
hit-hot-dot-dog-cog
hit-hot-lot-log-cog

depth = 5
 */

/*
Idea of solution:
1. Find min depth using BFS
2. Apply all possible path of min depth
 */

/*

Overview
This problem is an extension of the problem Word Ladder, where we only need to find the minimum number of words in the transformation from beginWord to endWord. Here, we need to find all the transformations that exist between beginWord and endWord that are the minimum length. We can use BFS to find the minimum number of words in the transformation, however, finding all such transformations is tricky because the number of transformations may be enormous.

Approach 1: Breadth-First Search (BFS) + Backtracking
Intuition

The problem can be correlated with the graph data structure. We can represent the words as the vertices and an edge can be used to connect two words which differ by a single letter.

Before diving further let's see how we can find all the direct connections of a particular word. To find the adjacent words for a particular word, one approach is to traverse all of the other words and add an edge for those that differ by a single letter. This approach requires O(N\cdot K)O(N⋅K) time where NN is the number of words given and KK is the maximum length of a word. The observation behind the optimal approach is that the words only consist of lowercase English letters. Hence we can change each character of the word to all other English lowercase characters and check whether or not that word exists in the wordList(this particular check operation takes O(1)O(1) in C++ while in Java it will take O(K)O(K) due to the immutable nature of Strings).This way the number of operations will be (25\cdot K*K + 1)(25⋅K∗K+1), hence the time complexity will be O(K^2)O(K
2
 ).

Thus we can find all the words that are directly connected. Now, the task is to find all of the shortest paths from beginWord to endWord.

The naive way to do this is to use backtracking. We will start from beginWord, then traverse all the adjacent words until we reach the endWord. When we reach the endWord, we can compare the path length and find all the paths that have the minimum path length. This method however is extremely inefficient because the number of paths between two vertices can be enormous.

Let's try to optimize our approach. Somehow, we need to reduce the number of traversed paths. Let's say the number of shortest paths that exist between beginWord and endWord is x and the number of paths that we must traverse to find these shortest paths is y. The closer the value y gets to the value x, the more efficient our approach will be.

The diagram below shows the graph that represents the connectivity among words. As shown in the diagram we want to go from red to tax. While backtracking on this graph, we will also cover the edges upwards that is from the tad to ted similarly from tex we will traverse to ted as well as rex. The key observation here is that going back in the upward direction will never lead us to the shortest path. We should always traverse the edges in the direction of beginWord to endWord. fig To ensure that we never traverse up the ladder, let's use directed edges to connect the words. The edges in the graph below are all directed towards endWord. Also, notice that graphs produced by BFS do not contain cycles. Thus, the graph will be a Directed Acyclic Graph (DAG). fig Now for the easy part, think of the previous graph as a bunch of layers and observe that once we reach a particular layer we don't want the future words to have the connection back to this layer. We will build our DAG using BFS. We will then add all the directed edges from the words present in the current layer and once all words in this layer have been traversed, we will remove them from the wordList. This way we will avoid adding any edges that point towards beginWord.

After constructing the graph, we can use our same backtracking approach to find the shortest paths between beginWord and endWord. Also, note that in the graph all paths between beginWord and endWord, obtained through BFS, will be the shortest possible. This is because all the edges in the graph will be directed in the direction of beginWord to endWord. Furthermore, there will not be any edge between the words that are on the same level. Therefore, iterating over any edge will bring us one step closer to the endWord, thus there is no need to compare the length of the path each time we reach the endWord.

Algorithm

Store the words present in wordList in an unordered set so that the words can be efficiently removed during the breadth-first search.

Perform the BFS, and add the edges to the adjacency list adjList. Also once a level is finished remove the visited words from the wordList.

Start from beginWord and while keep tracking of the current path as currPath traverse all the possible paths, whenever the path leads to the endWord store the path in shortestPaths.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    Map<String, List<String>> adjList = new HashMap<String, List<String>>();
    List<String> currPath = new ArrayList<>();
    List<List<String>> shortestPaths = new ArrayList<>();

    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<String>();
        char charList[] = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];

            // replace the i-th character with all letters from a to z except the original character
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;

                // skip if the character is same as original or if the word is not present in the wordList
                if (c == oldChar || !wordList.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }

    private void backtrack(String source, String destination) {
        // store the path if we reached the endWord
        if (source.equals(destination)) {
            List<String> tempPath = new ArrayList<String>(currPath);
            shortestPaths.add(tempPath);
        }

        if (!adjList.containsKey(source)) {
            return;
        }

        for (int i = 0; i < adjList.get(source).size(); i++) {
            currPath.add(adjList.get(source).get(i));
            backtrack(adjList.get(source).get(i), destination);
            currPath.remove(currPath.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // remove the root word which is the first layer in the BFS
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }

        Map<String, Integer> isEnqueued = new HashMap<>();
        isEnqueued.put(beginWord, 1);

        while (!q.isEmpty())  {
            // visited will store the words of current layer
            List<String> visited = new ArrayList<>();

            for (int i = q.size() - 1; i >= 0; i--) {
                String currWord = q.poll();

                // findNeighbors will have the adjacent words of the currWord
                List<String> neighbors = findNeighbors(currWord, wordList);
                for (String word : neighbors) {
                    visited.add(word);

                    if (!adjList.containsKey(currWord)) {
                        adjList.put(currWord, new ArrayList<>());
                    }

                    // add the edge from currWord to word in the list
                    adjList.get(currWord).add(word);
                    if (!isEnqueued.containsKey(word)) {
                        q.add(word);
                        isEnqueued.put(word, 1);
                    }
                }
            }
            // removing the words of the previous layer
            for (int i = 0; i < visited.size(); i++) {
                if (wordList.contains(visited.get(i))) {
                    wordList.remove(visited.get(i));
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // copying the words into the set for efficient deletion in BFS
        Set<String> copiedWordList = new HashSet<>(wordList);
        // build the DAG using BFS
        bfs(beginWord, endWord, copiedWordList);

        // every path will start from the beginWord
        currPath.add(beginWord);
        // traverse the DAG to find all the paths between beginWord and endWord
        backtrack(beginWord, endWord);

        return shortestPaths;
    }
}
