package com.bichel.leetcode.tree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree pr = new DiameterOfBinaryTree();

        TreeNode root = new TreeNode();

        pr.diameterOfBinaryTree(root);
    }

    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNode node){
        if(node == null) return 0;

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
