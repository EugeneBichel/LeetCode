package com.bichel.algorithms;

import java.util.HashMap;
import java.util.Map;

/*
Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values,
you should store the sparse vector efficiently and
compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?

A sparse vector is a vector that has mostly zero values,
while a dense vector is a vector where most of the elements are non-zero.


 */

class DotProductOfTwoSparseVectors {
    private Map<Integer, Integer> map;

    DotProductOfTwoSparseVectors(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                map.put(i, nums[i]);
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {

        int product = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (vec.containsIndex(entry.getKey()))
                product += entry.getValue() * vec.getValue(entry.getKey());
        }

        return product;
    }

    public boolean containsIndex(int key) {
        return this.map.containsKey(key);
    }
    public int getValue(int key) {
        return map.get(key);
    }
}
