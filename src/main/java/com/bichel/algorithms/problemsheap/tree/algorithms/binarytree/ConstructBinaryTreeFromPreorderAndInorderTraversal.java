package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

/*
Given two integer arrays preorder and
inorder where preorder is the preorder traversal
of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree.

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Time complexity : O(N)
Space complexity : O(N)


Preorder traversal follows Root -> Left -> Right,
    therefore, given the preorder array preorder,
    we have easy access to the root which is preorder[0].

Inorder traversal follows Left -> Root -> Right,
    therefore if we know the position of Root,
    we can recursively split the entire array into two subtrees.
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
