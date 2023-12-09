package com.bichel.algorithms.problemsheap.tree.algorithms.binarysearchtree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        List<Integer> items = new ArrayList<>();
        traverse(root, items);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < items.size(); i++) {
            min = Math.min(min, items.get(i) - items.get(i - 1));
        }

        return min;
    }

    private void traverse(TreeNode root, List<Integer> items) {
        if(root == null) {
            return;
        }

        traverse(root.left, items);
        items.add(root.val);
        traverse(root.right, items);
    }

    int min = Integer.MAX_VALUE; //global variable to store ans
    Integer preValue = null; //previous value, which we will use to compare

    //When we do inorder traversal on a bst we get all values sorted in increasing order. This is the logic that will be applied here
    public int getMinimumDifference2(TreeNode root) {
        if(root == null) { //base condition
            return min;
        }

        //since we are doing inorder traversal, first we are going to extreme left
        getMinimumDifference2(root.left);

        //if the preValue is not null then we subtract from the value of current node and compare with global 'min'
        if(preValue != null) {
            min = Math.min(min, root.val - preValue);
        }

        //we update the preValue for next node
        preValue = root.val;

        //after moving to left we move to right side
        getMinimumDifference2(root.right);

        return min;
    }
}
