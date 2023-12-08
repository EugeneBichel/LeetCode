package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

/*
You need to construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree.
It contains an integer followed by zero, one or two pairs of parenthesis.
The integer represents the root's value and a pair of parenthesis contains
a child binary tree with the same structure.
You always start to construct the left child node of the parent first if it exists.

Time Complexity: O(N)
Space Complexity: O(H)
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;
import com.bichel.algorithms.unsorted.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        return this.str2treeInternal(s, 0).getKey();
    }

    private Pair<Integer, Integer> getNumber(String s, int index) {

        boolean isNegative = false;

        // A negative number
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        }

        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            number = number * 10 + (s.charAt(index) - '0');
            index++;
        }

        return new Pair<Integer, Integer>(isNegative ? -number : number, index);
    }

    private Pair<TreeNode, Integer> str2treeInternal(String s, int index) {

        if (index == s.length()) {
            return new Pair<TreeNode, Integer>(null, index);
        }

        // Start of the tree will always contain a number representing
        // the root of the tree. So we calculate that first.
        Pair<Integer, Integer> numberData = this.getNumber(s, index);
        int value = numberData.getKey();
        index = numberData.getValue();

        TreeNode node = new TreeNode(value);
        Pair<TreeNode, Integer> data;

        // Next, if there is any data left, we check for the first subtree
        // which according to the problem statement will always be the left child.
        if (index < s.length() && s.charAt(index) == '(') {
            data = this.str2treeInternal(s, index + 1);
            node.left = data.getKey();
            index = data.getValue();
        }


        // Indicates a right child
        if (node.left != null && index < s.length() && s.charAt(index) == '(') {
            data = this.str2treeInternal(s, index + 1);
            node.right = data.getKey();
            index = data.getValue();
        }


        return new Pair<>(node, index < s.length() && s.charAt(index) == ')' ? index + 1 : index);
    }
}
