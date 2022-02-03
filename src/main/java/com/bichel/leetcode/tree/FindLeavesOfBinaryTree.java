package com.bichel.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public static void main(String[] args) {
        //1 2 3 4 5
        TreeNode root = insertNode(null, 3);
        insertNode(root, 2);
        insertNode(root, 4);
        insertNode(root, 1);
        insertNode(root, 5);

        List<List<Integer>> leafLevels = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            List<Integer> leaves = new ArrayList<>();
            findLeaves(root, leaves);
            leafLevels.add(new ArrayList<>(leaves));
            curr = removeLeaves(curr, leaves);
        }
    }

    static TreeNode insertNode(TreeNode root, int value) {
        if(root == null) {
            return new TreeNode(value);
        }

        boolean inserted = false;
        while(inserted == false) {
            if (value < root.val) {
                if(root.left != null) {
                    root = root.left;
                } else {
                    inserted = true;
                    root.left = new TreeNode(value);
                }
            } else if(value >= root.val) {
                if(root.right != null) {
                    root = root.right;
                } else {
                    inserted = true;
                    root.right = new TreeNode(value);
                }
            }
        }

        return root;
    }
    static void findLeaves(TreeNode root, List<Integer> leaves) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }
    static TreeNode removeLeaves(TreeNode root, List<Integer> leafs) {

        if (root == null || leafs.isEmpty()) {
            return root;
        }

        if (root.left == null && root.right == null) {

            if(leafs.contains(root.val)) {
                int index = leafs.indexOf(root.val);
                leafs.remove(index);
            }

            return null;
        }

        root.left = removeLeaves(root.left, leafs);
        root.right = removeLeaves(root.right, leafs);

        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    better solution
    private List<Pair<Integer, Integer>> pairs;

    private int getHeight(TreeNode root) {

        // return -1 for null nodes
        if (root == null) return -1;

        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // based on the height of the left and right children, obtain the height of the current (parent) node
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // collect the pair -> (height, val)
        this.pairs.add(new Pair<Integer, Integer>(currHeight, root.val));

        // return the height of the current node
        return currHeight;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.pairs = new ArrayList<>();

        getHeight(root);

        // sort all the (height, val) pairs
        Collections.sort(this.pairs, Comparator.comparing(p -> p.getKey()));

        int n = this.pairs.size(), height = 0, i = 0;

        List<List<Integer>> solution = new ArrayList<>();

        while (i < n) {
            List<Integer> nums = new ArrayList<>();
            while (i < n && this.pairs.get(i).getKey() == height) {
                nums.add(this.pairs.get(i).getValue());
                i++;
            }
            solution.add(nums);
            height++;
        }
        return solution;
    }
     */
}
