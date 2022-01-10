# LeetCode

Dynamic Programming (DP) is a programming paradigm that can systematically and efficiently explore all possible solutions to a problem. As such, it is capable of solving a wide variety of problems that often have the following characteristics:
- The problem can be broken down into "overlapping subproblems" - smaller versions of the original problem that are re-used multiple times.
- The problem has an "optimal substructure" - an optimal solution can be formed from optimal solutions to the overlapping subproblems of the original problem.

The Fibonacci sequence is a classic example used to explain DP. For those who are unfamiliar with the Fibonacci sequence, 
it is a sequence of numbers that starts with 0, 1, and each subsequent number is obtained by adding the previous two numbers together.

Greedy problems have optimal substructure, but not overlapping subproblems. 
Divide and conquer algorithms break a problem into subproblems, but these subproblems are not overlapping 
(which is why DP and divide and conquer are commonly mistaken for one another).

There are two ways to implement a DP algorithm:
- Bottom-up, also known as tabulation.
- Top-down, also known as memoization.

// Pseudocode example for bottom-up
F = array of length (n + 1)
F[0] = 0
F[1] = 1
for i from 2 to n:
    F[i] = F[i - 1] + F[i - 2]

// Pseudocode example for top-down
memo = hashmap
Function F(integer i):
    if i is 0 or 1: 
        return i
    if i doesn't exist in memo:
        memo[i] = F(i - 1) + F(i - 2)
    return memo[i]


Recall:
- The problem can be broken down into "overlapping subproblems" - smaller versions of the original problem that are re-used multiple times
- The problem has an "optimal substructure" - an optimal solution can be formed from optimal solutions to the overlapping subproblems of the original problem


The first characteristic that is common in DP problems is that the problem will ask for the optimum value (maximum or minimum) of something, or the number of ways there are to do something. For example:
- What is the minimum cost of doing...
- What is the maximum profit from...
- How many ways are there to do...
- What is the longest possible...
- Is it possible to reach a certain point...

The second characteristic that is common in DP problems is that future "decisions" depend on earlier decisions. Deciding to do something at one step may affect the ability to do something in a later step. 

Strictly speaking, both can be parallelized, however the steps required to parallelize dynamic programming approaches are quite complex. So generally speaking, divide and conquer approaches can be parallelized while dynamic programming approaches cannot be (easily) parallelized. This is because the subproblems in divide an conquer approaches are independent of one another (they do not overlap) while in dynamic programming, the subproblems do overlap.

When converting a top-down solution to a bottom-up solution, we can still use the same base case(s) and the same recurrence relation. However, bottom-up dynamic programming solutions iterate over all of the states (starting at the base case) such that all the results necessary to solve each subproblem for the current state have already been obtained before arriving at the current state. So, to convert a top-down solution into a bottom-up solution, we must first find a logical order in which to iterate over the states.


