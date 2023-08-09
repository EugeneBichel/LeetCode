package com.bichel.algorithms.problemsheap.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean used[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();

        for(int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        dfs(adj, used, order);

        Collections.reverse(order);

        return order;
    }

    private static void explore(ArrayList<Integer>[] adj, boolean[] used, ArrayList<Integer> postOrder, int s) {
        used[s] = true;
        ArrayList<Integer> list = adj[s];
        int N = list.size();

        for(int i = 0; i < N; i++) {
            int curr = list.get(i);

            if(used[curr] == false) {
                explore(adj, used, postOrder, curr);
            }
        }

        postOrder.add(s);
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] used, ArrayList<Integer> order) {
        for(int i = 0; i < adj.length; i++) {
            if(used[i] == false) {
                explore(adj, used, order, i);
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

