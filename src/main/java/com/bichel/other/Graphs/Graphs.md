## A graph G = (V, E) is defined by a set of vertexV, and a set of edges, E, over pairs of these vertices.

## There are 3 common types of graphs:
## ("Algorithms in a Nutshell" George T. Heinenman, Gary Pollice & Stanley Selkow)
- Undirected, unweighted graphs
    - These model relationships between vertices (u, v) without regard for the direction of the relationship.
    These graphs are useful for capturing symmetric information. For example, in a graph modeling social network, 
    if Alice is a friend of Bob, then Bob is a friend of Alice.

- Directed graphs
    - These model relationships between vertices (u, v) that are distinct from the relationship between (v, u),
    which may or may not exist. For example, a program to provide a driving directions must store information on one-way streets
    to avoid giving illegal directions. 

- Weighted graphs
    - These model relationships where there is a numeric value known as a weight associated with the relationship 
    between vertices (u, v).


## The following information is from [topcoder.com](https://www.topcoder.com/community/data-science/data-science-tutorials/introduction-to-graphs-and-their-data-structures-section-1/):

- A graph G = {V, E} is defined as a set of vertices, V, and a collection of edges (which is not necessarily a set), E.
An edge can then be defined as (u, v), where u and v are elements of V.

- Order - the number of vertices in a graph.
- Size - the number of edges in a graph.


## Graph data structures

 We can use adjacency list and adjacency matrices to store graphs.
 Also there are other representations like incidence matrix and incidence list.

## Traversal methods for trees
- preorder: visit each node before its children
- inorder (for binary trees only): visit left subtree, node, right subtree
- postorder: visit each node after its children

## Spanning tree
[Wikipedia](https://en.wikipedia.org/wiki/Spanning_tree)
    A spanning tree of an undirected graph G is a subgraph
    that is a tree which includes all of the vertices of G.
    In general, a graph may have several spanning trees,
    but a graph that is not connected will not contain a spanning tree.

    In order to minimize the cost of power networks, wiring connections, piping,
    automatic speech recognition, etc., systems often use algorithms that gradually build
    a spanning tree (or many such trees) as intermediate steps in the process
    of finding the minimum spanning tree.

    A tree is a connected undirected graph with no cycles.

    Every finite connected graph has a spanning tree.