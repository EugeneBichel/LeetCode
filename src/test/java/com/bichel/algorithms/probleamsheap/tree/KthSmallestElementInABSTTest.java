package com.bichel.algorithms.probleamsheap.tree;

import com.bichel.algorithms.problemsheap.tree.datastructure.BinarySearchTree;
import com.bichel.algorithms.problemsheap.tree.algorithms.binarysearchtree.KthSmallestElementInABST;
import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthSmallestElementInABSTTest {
    @Test
    public void test1() {
        //1 2 3 4 5
        BinarySearchTree binaryTree = new BinarySearchTree();
        TreeNode root = binaryTree.insertNode(null, 3);
        binaryTree.insertNode(root, 2);
        binaryTree.insertNode(root, 4);
        binaryTree.insertNode(root, 1);
        binaryTree.insertNode(root, 5);

        KthSmallestElementInABST pr = new KthSmallestElementInABST();
        int k = 1;
        int expected = 1;
        int actual = pr.kthSmallest(root, k);

        Assertions.assertEquals(expected, actual);
    }
}
