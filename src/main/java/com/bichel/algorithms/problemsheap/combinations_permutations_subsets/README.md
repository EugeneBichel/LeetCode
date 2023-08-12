Let us first review the problems of
Permutations / Combinations / Subsets,

since they are quite similar to each other
and there are some common strategies to solve them.

First, their solution space is often quite large:

Permutations: N!N!.

Combinations: C_N^k ={N!/(N - k)!*k!
Subsets: 2^N since each element could be absent or present.

Given their exponential solution space, it is tricky to ensure
that the generated solutions are complete and non-redundant.
It is essential to have a clear and easy-to-reason strategy.
There are generally three strategies to do it:

- Recursion
- Backtracking
- Lexicographic generation based on the mapping between binary bitmasks
  and the corresponding permutations / combinations / subsets.
