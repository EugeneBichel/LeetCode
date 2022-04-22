### DFS vs BFS
[wikipedia](https://en.wikipedia.org/wiki/Depth-first_search):
The time and space complexity are the same for DFS and BFS and the choice
of which of these two algortihms to use depends less on their complexity
and more on the different properties of the certex ordering the 
two algorithms produce.

## Depth-First Search

[wikipedia](https://en.wikipedia.org/wiki/Depth-first_search):
Depth-First Search (DFS) is an algorithm for traversing or searching tree or graph
data structures. One start at the root (selecting some arbitrary node ad the root in the case of a graph)
and explores as far as possible along each branch before backtracking.

A version of depth-first search was investigated in the 19th century by French mathematician
Charles Perre Tremaux as a strategy for solving mazes.


### "Algortihms in a Nutshell" by George T. Heineman, Gary Pollice and Stanley Selkow

G = (V, E), where V - vertexs, E - edges

The Depth-First Search dfs(u) is a recursive search that visits a vertex u 
that has not yet been visited. dfs(u) records its progress by coloring vertices
one of the colors:

- White
    Vertex has not yet been visited.

- Gray
    Vertex has been visited, but it may have an adjacent vertex that has not yet
    been visited.

- Black
    Vertex has been visited and so have all of its adjacent vertices.

Best, Average, Worst: O(V + E)

## Applications of Depth-First Search
[geeksforgeeks.org](http://www.geeksforgeeks.org/applications-of-depth-first-search/):

- For an unweighted graph, DFS traversal of the graph produces the minimum
spanning tree and all pair shortest path tree.
- Detecting cycle in a graph
    A graph has cycle if and only if we see a back edge during DFS.
- Path finding
    We can specialize the DFS algorithm to find a path between two given
    vertices u and z.
    - Call DFS(G, u) with u as the start vertex.
    - Use a stack S to keep track of the path between the start vertex 
    and the current vertex.
    - As soon as destination vertex z is encountered, return the path as the contents of the stack
- Topological Sorting
Topological Sorting is mainly used for scheduling jobs from the given
dependencies among jobs. In computer science, applications of this type arise
in instruction scheduling, ordering of formula cell evaluation when recomputing
formula values in speadsheets, logic synthesis, determining the order of
compilation tasks in makefiles, data serizalization, and resolving symbol dependencies in linkers.

- To test if a graph is bipartite
We can augment either BFS or DFS when we first discover a new vertex,
color it opposited its parents, and for each other edge, check it doesnot link
two vertices of the same color. The first vertex in any connected component can
be red or black.

- Finding Strongly Connected Components of a graph. A directed graph is called
strongly connected of there is a path from each vertex in the graph to every other vertex.

- Solving puzzles with only one solution, such as mazes.
