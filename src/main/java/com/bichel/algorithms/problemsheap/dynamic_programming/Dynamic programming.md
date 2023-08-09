[wikipedia](https://en.wikipedia.org/wiki/Dynamic_programming):
    Dynamic programming (also knows as dynamic optimization) is a method 
    for solving a complex problem by breaking it down into a collection of simpler
    subproblems, solving each of those subproblems just once, and storing
    their solutions - ideally, using a memory-based data structure.  The next time
    the same subproblem occurs, instead of recompiling its solution,
    one simply looks up the previously computed solutions, thereby saving computation time
    at the expense of a modest expenditure in storage space.

    The technique of storing solutions to subproblems instead of
    recomputing them is called "memoization"

[Introduction to Algorithms 3rd Edition by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844):
    Dynamic programming, like the divide-and-conquer method, solves problems by 
    combining the solutions to subproblems. ("Programming" in this context refers
    to a tabular method, not to writing computer code). Devide-and-conquer algorithms 
    partition the problem into disjoint subproblems, solve the subproblems recursively,
    and then combine their solution to solve the original problem. In contrast, dynamic
    programming applies when the subproblems overlap - that is, when subproblems share
    subsubproblems. In this context, a divide-and-conquer algorithm does more work than
    necessary, repeatedly solving the common subsubproblems. A dynamic programming algorithms
    solves each subsubproblem just once and then saves its answer in a table, thereby 
    avoiding the work of recomputing the answer every time it solves each subsubproblem.

When solving a problem by dynamic programming, the most crucial question is,
what are the subproblems?

[www.topcoder.com](https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/):
    A DP is an algorithmic technique which is usually based on a recurrent formula 
    and one (or some) starting states. A sub-solution of the problem is constructed
    from previously found ones. DP solutions have a polynomial complexity which assures a much faster running time 
    than other technique like backtracking, brute-force etc.