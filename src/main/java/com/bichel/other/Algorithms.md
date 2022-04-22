# Four algorithms approaches to solving problems:
# ("Algorithms in a Nutshell" George T. Heinenman, Gary Pollice & Stanley Selkow)

## Deterministic algorithms
    solve instances of a problem bi giving an exact answer on a sequential, 
    deterministic computer
    - Greedy
    - Divide and Conquer
    - Dynamic Programming
    
## Approximation algorithms
    instead of seeking an exact answer for a problem, accept solutions that are close to, 
    but not necessarily as good as, the true result

## Parallel algorithms
    Instead of being restricted to sequential computation, create multiple computational processes 
    to work simultaneously on subproblem instances

## Probabilistic algorithms
    Instead of computing the same result for a problem instance, 
    use randomized computations to compute an answer. When run multiple times,
    the answer often converge on the true answer


# Criteria for Choosing a Sorting Algorithm 
# ("Algorithms in a Nutshell" George T. Heinenman, Gary Pollice & Stanley Selkow)
 - Insertion Sort
    - Only a few items
- Insertion Sort
    - Items are mostly sorted already
- Heap Sort
    - Concerned about worst-case scenarios
- Quicksort
    - Interested in a good average-case behavior
- Bucket Sort
    - Items are drawn from a uniform dense universe
- Insertion Sort
    - Desire to write as little code as possible
- Merge Sort
    - Require stable sort
