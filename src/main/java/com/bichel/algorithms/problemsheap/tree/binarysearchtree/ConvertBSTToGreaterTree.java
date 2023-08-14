package com.bichel.algorithms.problemsheap.tree.binarysearchtree;

/*
Given the root of a Binary Search Tree (BST),
convert it to a Greater Tree such that every key of the original BST
is changed to the original key plus the sum of all keys greater
than the original key in BST.

time complexity : O(n)
 */

import com.bichel.algorithms.problemsheap.tree.TreeNode;

import java.util.Stack;

public class ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    /*
    Time complexity : O(n)
     */
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }

    /*
    Reverse Morris In-order Traversal
     */
        /* Get the node with the smallest value greater than this one. */
        private TreeNode getSuccessor(TreeNode node) {
            TreeNode succ = node.right;
            while (succ.left != null && succ.left != node) {
                succ = succ.left;
            }
            return succ;
        }
        public TreeNode convertBST3(TreeNode root) {
            int sum = 0;
            TreeNode node = root;

            while (node != null) {
                /*
                 * If there is no right subtree, then we can visit this node and
                 * continue traversing left.
                 */
                if (node.right == null) {
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
                /*
                 * If there is a right subtree, then there is at least one node that
                 * has a greater value than the current one. therefore, we must
                 * traverse that subtree first.
                 */
                else {
                    TreeNode succ = getSuccessor(node);
                    /*
                     * If the left subtree is null, then we have never been here before.
                     */
                    if (succ.left == null) {
                        succ.left = node;
                        node = node.right;
                    }
                    /*
                     * If there is a left subtree, it is a link that we created on a
                     * previous pass, so we should unlink it and visit this node.
                     */
                    else {
                        succ.left = null;
                        sum += node.val;
                        node.val = sum;
                        node = node.left;
                    }
                }
            }

            return root;
        }
}
