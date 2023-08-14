package com.bichel.algorithms.probleamsheap.tree;

import com.bichel.algorithms.problemsheap.tree.algorithms.binarytree.FindLeavesOfBinaryTree;
import com.bichel.algorithms.problemsheap.tree.datastructure.BinarySearchTree;
import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTreeTest {
    @Test
    public void test1() {

        FindLeavesOfBinaryTree pr = new FindLeavesOfBinaryTree();
        BinarySearchTree tree = new BinarySearchTree();

        //1 2 3 4 5
        TreeNode root = tree.insertNode(null, 3);
        tree.insertNode(root, 2);
        tree.insertNode(root, 4);
        tree.insertNode(root, 1);
        tree.insertNode(root, 5);

        List<List<Integer>> leafLevels = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            List<Integer> leaves = new ArrayList<>();
            pr.findLeaves(root, leaves);
            leafLevels.add(new ArrayList<>(leaves));
            curr = tree.removeLeaves(curr, leaves);
        }
    }
}
