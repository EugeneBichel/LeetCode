package com.bichel.other.basic;

import java.util.HashMap;
import java.util.Map;

public class EscapingReference {
    public static void main(String[] args) {
        Map<Integer, String> customers = new HashMap<>();
        customers.put(1, "Tom");
        customers.put(2, "Peter");

        Map<Integer, String> copiedMap = Map.copyOf(customers);

        //can't modified immutable collection
        //copiedMap.clear();

        for(String value: copiedMap.values()) {
            System.out.println(value);
        }

        //https://www.udemy.com/course/java-application-performance-and-memory-management/learn/lecture/13918208#notes
        // using Interface + modules is a good way to solve a problem of escaping references
    }
}
