package com.bichel.java.collections;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        //HashSet is a HashMap, where value is just new Object() instance as dummy. HashSet uses only keys of HashMap

        /**
         * When the total number of items in hashmap goes on increasing keeping the default initial capacity of
         * hashmap 16, At one point of time, hashmap performance will start degrading and need to increase buckets
         * for improving performance.

         Load Factor is a measure, which decides when exactly to increase the hashmap capacity(buckets)
         to maintain get and put operation complexity of O(1).

         Default load factor of Hashmap is 0.75f (i.e 75% of current map size).

         Load Factor is a measure which decides when exactly to increase the hashmap capacity or
         you can say bucket capacity, so that get and put operation can still have O(1) complexity.

         Default, initial capacity of the HashMap is 16 and Load factor is 0.75

         This represents that uptil 12th key-value pair hashmap will keep its size to 16
         and as soon as 13th item(key-value pair) will come into the Hashmap,
         it will increase its size from default 2^4 = 16 buckets to 2^5 = 32 buckets.

         */

        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(3);

        System.out.println(hashSet.size()); // 1
    }
}
