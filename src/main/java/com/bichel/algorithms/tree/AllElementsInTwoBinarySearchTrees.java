package com.bichel.algorithms.tree;

import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        inorder(root1, l1);

        List<Integer> l2 = new LinkedList<>();
        inorder(root2, l2);

        List<Integer> res = new LinkedList<>();

        int i = 0;
        int j = 0;

        while(i < l1.size() && j < l2.size()) {
            if(l1.get(i) < l2.get(j)) {
                res.add(l1.get(i++));
            }
            else {
                res.add(l2.get(j++));
            }
        }

        while(i < l1.size()) {
            res.add(l1.get(i++));
        }
        while(j < l2.size()) {
            res.add(l2.get(j++));
        }

        return res;
    }

    private void inorder(TreeNode root, List<Integer> l) {

        if(root == null) return;

        if(root.left != null)
            inorder(root.left, l);

        l.add(root.val);

        if(root.right != null)
            inorder(root.right, l);
    }
}
