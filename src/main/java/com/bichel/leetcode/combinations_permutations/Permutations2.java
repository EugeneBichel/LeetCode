package com.bichel.leetcode.combinations_permutations;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        List<Integer> origin = new ArrayList<>();
        for(int x: nums) origin.add(x);

        backtrack(nums.length, origin, res, 0);

        return new ArrayList<>(res);
    }

    private void backtrack(int n, List<Integer> origin, Set<List<Integer>> res, int first) {
        if(first == n) res.add(new ArrayList<>(origin));

        for(int i=first; i<n; i++) {
            Collections.swap(origin, first, i);

            backtrack(n, origin, res, first+1);

            Collections.swap(origin, first, i);
        }
    }
}
