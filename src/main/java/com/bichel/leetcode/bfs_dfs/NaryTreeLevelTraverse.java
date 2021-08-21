package com.bichel.leetcode.bfs_dfs;

import com.bichel.leetcode.graph.NtierNode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelTraverse {
    public List<List<Integer>> levelOrder(NtierNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        bfs(root, levels, 0);

        return levels;
    }

    private void bfs(NtierNode root, List<List<Integer>> levels, Integer level) {
        if(root == null) return;

        if(level == levels.size()) levels.add(new ArrayList<>());

        levels.get(level).add(root.val);

        for(int i=0; i< root.children.size(); i++) {
            bfs(root.children.get(i), levels, level+1);
        }
    }
}
