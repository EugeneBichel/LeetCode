package com.bichel.algorithms.problemsheap.tree.algorithms.binarysearchtree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(N), where N is the number of nodes in the tree.
Space Complexity: O(N)

For the recursive implementation, the recursion will consume additional space
in the function call stack.
In the worst case, the tree is of chain shape,
and we will reach all the way down to the leaf node.

For the iterative implementation, essentially we are doing a BFS
(Breadth-First Search) traversal, where the stack will contain no more than two levels
of the nodes. Therefore, the maximal space needed for the stack would be O(N).
 */

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        int sum = 0;
        for (Integer val : arr) {
            if (val >= low) {
                sum += val;
            }
            if (val == high) {
                break;
            }
        }

        return sum;
    }

    private void inorder(TreeNode node, List<Integer> l) {
        if (node == null) return;

        inorder(node.left, l);
        l.add(node.val);
        inorder(node.right, l);

    }

    int ans;

    public int rangeSumBST2(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
}
