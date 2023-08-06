package com.bichel.algorithms.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {

        int isCyclic = 0;
        int N = adj.length;

        for(int i = 0; i < N; i++) {
            isCyclic = dfs(adj, i, i);
            if(isCyclic == 1) {
                return 1;
            }
        }

        return 0;
    }

    private static int dfs(ArrayList<Integer>[] adj, int currNode, int source) {

        boolean[] visited = new boolean[adj.length];

        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(currNode);

        while(stack.empty() == false) {

            int currItem = stack.pop();
            visited[currItem] = true;

            int N = adj[currItem].size();
            ArrayList<Integer> list = adj[currItem];

            for(int i = 0; i < N; i++) {

                if(list.get(i) == source) {
                    return 1;
                }

                if(visited[list.get(i)] == false){
                    stack.push(list.get(i));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

