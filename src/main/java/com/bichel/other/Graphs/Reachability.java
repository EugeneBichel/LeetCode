package com.bichel.other.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {

        int result = 0;

        boolean[] visited = new boolean[adj.length];
        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        result = 1;

        explore(adj, x, visited);

        if(visited[y] == false) {
            result = 0;
        }

        return result;
    }

    private static void explore(ArrayList<Integer>[] adj, int index, boolean[] visited) {
        visited[index] = true;
        for (int j = 0; j < adj[index].size(); j++) {
            if (!visited[adj[index].get(j)]) {
                explore(adj, adj[index].get(j), visited);
            }
        }
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

