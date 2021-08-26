package com.bichel.leetcode.bfs_dfs;

import com.bichel.leetcode.graph.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalUsingRecursion {
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return levels;
        }
        bfs(root, 0);

        return levels;
    }

    private void bfs(TreeNode root, int level) {

        if(root == null) return;

        if(levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if(root.left != null) bfs(root.left, level+1);
        if(root.right != null) bfs(root.right, level+1);
    }

    public static class BinaryTreeVerticalOrderTraversal {

        class Pair<K, V> {
            private K key;
            private V val;

            public Pair(K key, V value) {
                this.key = key;
                this.val = value;
            }

            public K getKey() {return key;}
            public V getValue() {return val;}
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            if(root == null) return ans;

            Map<Integer, List<Integer>> cols = new HashMap<>();
            Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();

            int col = 0;
            q.add(new Pair(col, root));

            while(!q.isEmpty()) {
                Pair<Integer, TreeNode> p = q.poll();
                col = p.getKey();
                TreeNode node = p.getValue();

                if(node != null) {
                    if(!cols.containsKey(col)) cols.put(col, new ArrayList<>());

                    cols.get(col).add(node.val);

                    q.add(new Pair(col-1, node.left));
                    q.add(new Pair(col+1, node.right));
                }
            }


            List<Integer> keys = new ArrayList<>(cols.keySet());
            Collections.sort(keys);

            for(int k: keys) {
                ans.add(cols.get(k));
            }

            return ans;
        }
    }
}
