package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length - 1);
    }

    private TreeNode inorder(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int middle = (left + right) / 2;
        int value = nums[middle];

        TreeNode node = new TreeNode(value);
        node.left = inorder(nums, left, middle - 1);
        node.right = inorder(nums, middle + 1, right);

        return node;
    }
}
