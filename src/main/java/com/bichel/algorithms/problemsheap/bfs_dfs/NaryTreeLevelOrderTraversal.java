package com.bichel.algorithms.problemsheap.bfs_dfs;

import com.bichel.algorithms.problemsheap.graph.NtierNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NtierNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;

        Queue<NtierNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            int lenLevel = queue.size();

            for(int i=0; i<lenLevel; i++) {
                NtierNode node = queue.remove();
                level.add(node.val);

                for(int j=0; j<node.children.size(); j++) {
                    queue.add(node.children.get(j));
                }
            }

            levels.add(level);
        }

        return levels;
    }
}
