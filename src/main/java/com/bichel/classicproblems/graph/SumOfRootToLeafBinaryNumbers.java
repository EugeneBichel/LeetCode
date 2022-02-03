package com.bichel.classicproblems.graph;

/*
You are given the root of a binary tree where each node has a value 0 or 1.
Each root-to-leaf path represents a binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented
by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.


If you work with decimal representation, the conversion of 1->2 into 12 is easy.
You start from curr_number = 1,
 then shift one register to the left and add the next digit: curr_number = 1 * 10 + 2 = 12.

If you work with binaries 1 -> 1 -> 3, it's the same.
You start from curr_number = 1,
then shift one register to the left and add the next digit: curr_number = (1 << 1) | 1 = 3.
 */

import com.bichel.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfRootToLeafBinaryNumbers {

    class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currNumber = p.getValue();

            if (root != null) {
                currNumber = (currNumber << 1) | root.val;

                // if it's a leaf, update root-to-leaf sum
                if (root.left == null && root.right == null) {
                    rootToLeaf += currNumber;
                } else {
                    stack.push(new Pair(root.right, currNumber));
                    stack.push(new Pair(root.left, currNumber));
                }
            }
        }

        return rootToLeaf;
    }
}
