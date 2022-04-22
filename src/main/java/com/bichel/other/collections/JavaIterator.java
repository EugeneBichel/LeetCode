package com.bichel.other.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JavaIterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String currItem = iterator.next();
            System.out.println(currItem);
        }

        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            boolean hasPrev = listIterator.hasPrevious();

        }
    }
}
