All-Pair Shortest Path (APSP) Problem
    ○ Floyd-Warshall (not covered in KT)

● Obtaining actual shortest paths
    ○ O(n2) approach vs. O(n) approach (Bellman-Ford)
    ○ O(n3) approach vs. O(n2) approach (Floyd-Warshall)


● Dijkstra’s Algorithm and Bellman-Ford Algorithm solve the Single-Source
Shortest Path Problem (SSSP).

What if we want to compute pairwise shortest path distances?
○ That is, we want to compute d(v, w) for every pair (v, w) in G.
○ We can run Dijkstra’s Algorithm O(n) times or Bellman-Ford Algo O(n) times.
(Exercise: What’d be the running time of these approaches?)
○ We can think of a new (DP) algorithm -- Floyd-Warshall!
