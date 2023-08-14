package com.bichel.algorithms.problemsheap.tree.algorithms.binarysearchtree;

/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.List;
import java.util.ArrayList;

public class BinarySearchTreeIterator {
    private TreeNode root;
    private List<TreeNode> list;
    private TreeNode[] arr;
    private int ind;

    public BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
        ind = 0;
        fillArr();
    }

    private void fillArr() {
        list = new ArrayList<>();
        inorder(root);

        arr = new TreeNode[list.size()];
        int i = 0;
        for (TreeNode item : list) {
            arr[i++] = item;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    public int next() {
        return arr[ind++].val;
    }

    public boolean hasNext() {
        return ind < arr.length;
    }
}
