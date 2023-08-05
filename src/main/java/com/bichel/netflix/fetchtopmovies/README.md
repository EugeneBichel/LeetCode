
Now, we need to build a criterion so the top movies from multiple countries will combine into a single list of top-rated movies. In order to scale, the content search is performed in a distributed fashion. Search results for each country are produced in separate lists. Each member of a given list is ranked by popularity, with 1 being most popular and popularity decreasing as the rank number increases.

Let’s say that the following titles are represented by the provided IDs:

Lion King -> 11
White Tiget -> 23
Inception -> 32
Spped -> 38
Tenet -> 1
Top Gun -> 44
Con Air -> 23
Frozen -> 57
Jumanji -> 99

We’ll be given n arrays that are all sorted in ascending order of popularity rank. We have to combine these lists into a single list that will be sorted by rank in ascending order, meaning from best to worst.

Keep in mind that the ranks are unique to individual movies and a single rank can be in multiple lists.

Let’s understand this better with an illustration:

List #1:
head > 11 > 23 > 32 > 38 > tail

List #2:
head > 1 > 44 > tail

List #3:
head > 23 > 57 > 99 > tail

Final Combined List:
1 > 11 > 23 > 23 > 32 > 38 > 44 > 57 > 99

Since our task involves multiple lists, you should divide the problem into multiple tasks, starting with the problem of combining two lists at a time. Then, you should combine the result of those first two lists with the third list, and so on, until the very last one is reached.


Let’s discuss how we will implement this process:

Consider the first list as the result, and store it in a variable.

Traverse the list of lists, starting from the second list, and combine it with the list we stored as a result. The result should get stored in the same variable.

Time Complexity #
The time complexity will be O(k×n), where k is the number of the lists and n is the maximum length of a single list.

Space complexity #
O(1), as constant space was utilized.


