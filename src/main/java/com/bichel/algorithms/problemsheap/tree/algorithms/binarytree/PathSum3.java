package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

/*
Given the root of a binary tree and an integer targetSum,
return the number of paths where the sum of the values
along the path equals targetSum.

The path does not need to start or end at the root or a leaf,
but it must go downwards
(i.e., traveling only from parent nodes to child nodes).
 */

/*
Solution:
Prefix sum is a sum of the current value with all previous elements
starting from the beginning of the structure.

You might want to use the prefix sum technique for the problems like
"Find a number of continuous subarrays/submatrices/tree paths
that sum to target".


 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    int count = 0;
    int k;
    Map<Integer, Integer> h = new HashMap();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;

        // current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
        count += h.getOrDefault(currSum - k, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }
}
