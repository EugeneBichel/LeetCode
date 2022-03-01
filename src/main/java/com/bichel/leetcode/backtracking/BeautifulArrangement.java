package com.bichel.leetcode.backtracking;

/*
Suppose you have n integers labeled 1 through n.
A permutation of those n integers perm (1-indexed) is considered
a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

Example 1:
Input: n = 2
Output: 2
Explanation:
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
 */

public class BeautifulArrangement {

    int count = 0;

    /*
    Time complexity : O(k). k refers to the number of valid permutations.
    Space complexity : O(n). The depth of recursion tree can go upto nn.
        Further, nums array of size nn is used, where, n is the given number.
     */

    public int countArrangement(int N) {
        int[] nums = new int[N];

        for (int i = 1; i <= N; i++)
            nums[i - 1] = i;

        permute(nums, 0);

        return count;
    }
    private void permute(int[] nums, int l) {
        if (l == nums.length) {
            count++;
        }

        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);

            if (nums[l] % (l + 1) == 0 || (l + 1) % nums[l] == 0)
                permute(nums, l + 1);

            swap(nums, i, l);
        }
    }
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /*
    backtracking

    Time complexity : O(k). kk refers to the number of valid permutations.

    Space complexity : O(n). visited array of size n is used.
    The depth of recursion tree will also go upto n.
    Here, nn refers to the given integer n.
     */
    public int countArrangement2(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    private void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
