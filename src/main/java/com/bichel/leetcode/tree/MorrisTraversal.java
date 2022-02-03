package com.bichel.leetcode.tree;

public class MorrisTraversal {
    public static void main(String[] args) {

        MorrisTraversal pr = new MorrisTraversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        pr.morris(root);
    }

    void morris(TreeNode root) {
        if (root == null)
            return;

        TreeNode curr, prev;

        curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                /* Find the previous (prev) of curr */
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                /* Make curr as right child of its prev */
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }

                /* fix the right child of prev*/
                else {
                    prev.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }
}