package com.bichel.algorithms.problemsheap.tree;

/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
You can think of the left and right pointers as synonymous
to the predecessor and successor pointers in a doubly-linked list.
For a circular doubly linked list, the predecessor of the first element is the last element,
and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation,
the left pointer of the tree node should point to its predecessor,
and the right pointer should point to its successor.
You should return the pointer to the smallest element of the linked list.
 */

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    // the smallest (first)
    TreeNode first = null;
    //the largest (last) nodes
    TreeNode last = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }

    private void helper(TreeNode node) {
        if (node != null) {
            helper(node.left);

            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;

            helper(node.right);
        }
    }
}
