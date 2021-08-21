package com.bichel.leetcode.graph;

public class LowestCommonAncestor {

    private boolean hasP = false;
    private boolean hasQ = false;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.left.left = new TreeNode(8);

        LowestCommonAncestor pr = new LowestCommonAncestor();

        TreeNode lca = pr.lowestCommonAncestor(root,
                new TreeNode(5), new TreeNode(10));

        if (lca != null)
            System.out.println(lca.val);
        else
            System.out.println("null");
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLca(root, p, q);
        return hasP == true && hasQ == true ? lca : null;
    }

    private TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode leftLca = findLca(root.left, p, q);
        TreeNode rightLca = findLca(root.right, p, q);

        if(hasP == false && root.val == p.val) {
            hasP = true;
        }
        if(hasQ == false && root.val == q.val) {
            hasQ = true;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        if(leftLca != null && rightLca != null) return root;
        if(leftLca == null && rightLca == null) return null;

        return leftLca != null ? leftLca : rightLca;
    }
}
