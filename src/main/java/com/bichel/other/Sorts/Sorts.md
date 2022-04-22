## Sorting Overview

Sorting is arranging data in a collection based on a comparison algorithm.

## Stable and not stable sorting algorithms
The information from [wikipedia](https://en.wikipedia.org/wiki/Sorting_algorithm#Stability):
- Stable sorting algorithms choose one of the items with the same rank, according to the following rule: 
if two items compare as equal, 
like the two 5 cards, then their relative order will be preserved, so that if one came before the 
other in the input, it will also come before the other in the output.
More formally, the data being sorted can be represented as a record or tuple of values, and the 
part of the data that is used for sorting is called the key. In the card example, c
ards are represented as a record(rank, suit), and the key is the rank. A sorting algorithm is stable if whenever there are two records R and S with the same key, and R appears before S in the original list, then R will always appear before S in the sorted list.

## Comparison sorts and non-comparison sorts
The information from [wikipedia](https://en.wikipedia.org/wiki/Sorting_algorithm#Stability)
- Comparison sorts:
	- Quicksort
	- Merge sort
	- In-place merge sort
	- Heapsort
	- insertion sort
	- Introsort
	- Selection sort
	- Timsort
	- Cubesort
	- Shell sort
	- Bubble sort
	- Binary tree sort
	- Cycle sort
	- Library sort
	- Patience sorting
	- Smoothsort
	- Tournament sort
	- Cocktail sort
	- Comb sort
	...
- Non-comparison sorts:
	- Pigeonhole sort
	- Bucket sort
	- Counting sort
	- LSD radix sort
	- MSD radix sort
	- Spreadsort
	- Burstsort
	- Flashsort
	- Postman sort

## Two general families of sorting algorithms
- Linear Sorting
- Divide and Conquer

### Linear algorithms treat the problem of sorting as a single large operation.

### Divide and Conquer algorithms partition the data to be sorted into smaller sets that can be independently sorted.

## Measuring Performance

### Comparisons
- When 2 values of the input array are compared for relative equality: equal to, 
greater then less then

### Swaps
- When 2 values stored in the input array are swapped
 [1, 0] => [0, 1]
 
### Performance Considerations
- Comparisons and Swaps both have a cost
- Reducing either or both can improve performance
- The cost of both operations depends on many factors.

## Bubble Sort
- Simplest sorting algorithm
- On Each Pass
	- Compare each array item to it's right neighbor
	- If the right neighbor is smaller then Swap right and left
	- Repeat for the remaing array items
- Perform subsequent passes until no swaps are performed

- Worst case performance: O(n*n)
	- Not appropriate for large unsorted data sorted
- Average case performance: O(n*n)
	- Not appropriate for large unsorted data sorted
- Best case performance: O(n)
	- Very good best case performance and can efficiency sort small and nearly sorted data sets
- Space required: O(n)
	- Bubble sort operates directly on the input array meaning it is a candidate algorithm when 
	minimizing space is paramount.
