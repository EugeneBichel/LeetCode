Floyd-Warshall Algorithm
● Problem: Compute pairwise shortest path distances.
● Assume V = {v1, v2, …, vn}.
● OPTk[i, j] : Shortest path distance from vi to vj
,
only using {v1, v2, …, vk} as intermediate nodes.

● Problem: Compute pairwise shortest path distances.
● Assume V = {v1, v2, …, vn}.
● OPTk[i, j] : Shortest path distance from vi to vj
,
only using {v1, v2, …, vk} as intermediate nodes.
○ Base cases (k = 0): OPT0[i, i] := c(i, j) -- assume that c(i, i) = 0.
○ Main cases (k > 0): OPTk[i, j] := min( OPTk-1[i, j], OPTk-1[i, k] + OPTk-1[k, j])

How to Obtain Shortest Paths?
● Computing shortest path distances (numbers) vs. constructing paths
● In all three shortest-path algorithms, we only need to store the
“predecessor node” per destination.
○ Dijkstra’s Algorithm: Each time d[v] is improved (i.e., decreased), store pre[v]
:= w.
○ Bellman-Ford Algorithm: Each time OPT[v, k] is improved, store pre[v, k] := w.
Each time OPT[v] is improved,
store pre[v] := w.
○ Floyd-Warshall Algorithm: Each time OPT[i, j, k] is improved, store pre[i, j] := k.
Each time OPT[i, j] is improved, 
