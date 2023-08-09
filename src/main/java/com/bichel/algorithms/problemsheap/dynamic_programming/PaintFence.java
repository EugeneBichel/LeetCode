package com.bichel.algorithms.problemsheap.dynamic_programming;

/*
You are painting a fence of n posts with k different colors. You must paint the posts following these rules:

Every post must be painted exactly one color.
There cannot be three or more consecutive posts with the same color.
Given the two integers n and k, return the number of ways you can paint the fence.
 */

/*
Realizing This is a Dynamic Programming Problem

There are two parts to this problem that tell us it can be solved with dynamic programming.

First, the question is asking for the "number of ways" to do something.

Second, we need to make decisions that may depend on previously made decisions. In this problem, we need to decide what color we should paint a given post, which may change depending on previous decisions. For example, if we paint the first two posts the same color, then we are not allowed to paint the third post the same color.

Both of these things are characteristic of dynamic programming problems.

A Framework to Solve Dynamic Programming Problems

A dynamic programming algorithm typically has 3 components. Learning these components is extremely valuable, as most dynamic programming problems can be solved this way.

First, we need some function or array that represents the answer to the problem for a given state. For this problem, let's say that we have a function totalWays, where totalWays(i) returns the number of ways to paint i posts. Because we only have one argument, this is a one-dimensional dynamic programming problem.

Second, we need a way to transition between states, such as totalWays(3) and totalWays(4). This is called a recurrence relation and figuring it out is usually the hardest part of solving a problem with dynamic programming. We'll talk about the recurrence relation for this problem below.

The third component is establishing base cases. If we have one post, there are k ways to paint it. If we have two posts, then there are k * k ways to paint it (since we are allowed to paint have two posts in a row be the same color). Therefore, totalWays(1) = k, totalWays(2) = k * k.

Finding The Recurrence Relation

We know the values for totalWays(1) and totalWays(2), now we need a formula for totalWays(i), where 3 <= i <= n. Let's think about how many ways there are to paint the i^{th}i
th
  post. We have two options:

Use a different color than the previous post. If we use a different color, then there are k - 1 colors for us to use. This means there are (k - 1) * totalWays(i - 1) ways to paint the i^{th}i
  post a different color than the (i - 1)^{th}(i−1)
th
  post.

Use the same color as the previous post. There is only one color for us to use, so there are 1 * totalWays(i - 1) ways to paint the i^{th}i
th
  post the same color as the (i - 1)^{th}(i−1)
th
  post. However, we have the added restriction of not being allowed to paint three posts in a row the same color. Therefore, we can paint the i^{th}i
th
  post the same color as the (i - 1)^{th}(i−1)
th
  post only if the (i - 1)^{th}(i−1)
th
  post is a different color than the (i - 2)^{th}(i−2)
th
  post.

So, how many ways are there to paint the (i - 1)^{th}(i−1)
th
  post a different color than the (i - 2)^{th}(i−2)
th
  post? Well, as stated in the first option, there are (k - 1) * totalWays(i - 1) ways to paint the i^{th}i
th
  post a different color than the (i - 1)^{th}(i−1)
th
  post, so that means there are 1 * (k - 1) * totalWays(i - 2) ways to paint the (i - 1)^{th}(i−1)
th
  post a different color than the (i - 2)^{th}(i−2)
th
  post.

Adding these two scenarios together gives totalWays(i) = (k - 1) * totalWays(i - 1) + (k - 1) * totalWays(i - 2), which can be simplified to:

totalWays(i) = (k - 1) * (totalWays(i - 1) + totalWays(i - 2))

This is our recurrence relation which we can use to solve the problem from the base cases.
 */

/*
For this approach, we are using a hash map as our data structure
to memoize function calls. We could also use an array since the calls
to totalWays are very well defined (between 1 and n).

However, a hash map is used for most top-down dynamic programming solutions, as there will often be multiple function arguments, the arguments might not be integers, or a variety of other reasons that require a hash map instead of an array. Although using an array is slightly more efficient, using a hash map here is a good practice that can be applied to other problems.
 */

import java.util.HashMap;
import java.util.Map;

public class PaintFence {
    ////top-down dp solution
    private Map<Integer, Integer> memo = new HashMap<>();

    private int totalWays(int i, int k) {
        if (i == 1) return k;
        if (i == 2) return k * k;

        // Check if we have already calculated totalWays(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // Use the recurrence relation to calculate totalWays(i)
        memo.put(i, (k - 1) * (totalWays(i - 1, k) + totalWays(i - 2, k)));
        return memo.get(i);
    }

    public int numWays(int n, int k) {
        return totalWays(n, k);
    }
}

/*
Approach 2: Bottom-Up Dynamic Programming (Tabulation)
Intuition

Bottom-up dynamic programming is also known as tabulation and is done iteratively. Instead of using a function like in top-down, let's use an array totalWays instead, where totalWays[i] represents the number of ways you can paint i fence posts.

As the name suggests, we now start at the bottom and work our way up to the top (n). Initialize the base cases totalWays[1] = k, totalWays[2] = k * k, and then iterate from 3 to n, using the recurrence relation to populate totalWays.

Bottom-up algorithms are generally considered superior to top-down algorithms. Typically, a top-down implementation will use more space and take longer than the equivalent bottom-up approach.
 */

/*
Algorithm

Define an array totalWays of length n + 1, where totalWays[i] represents the number of ways you can paint i fence posts. Initialize totalWays[1] = k and totalWays[2] = k * k.

Iterate from 3 to n, using the recurrence relation to populate totalWays: totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]).

At the end, return totalWays[n].
 */

/*

public int numWays(int n, int k) {
        // Base cases for the problem to avoid index out of bound issues
        if (n == 1) return k;
        if (n == 2) return k * k;

        int totalWays[] = new int[n + 1];
        totalWays[1] = k;
        totalWays[2] = k * k;

        for (int i = 3; i <= n; i++) {
            totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);
        }

        return totalWays[n];
    }

 */
