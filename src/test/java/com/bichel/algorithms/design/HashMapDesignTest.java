package com.bichel.algorithms.design;

import com.bichel.design.HashMapDesign;
import org.junit.jupiter.api.Test;

public class HashMapDesignTest {
    @Test
    public void testTestCase1() {
        HashMapDesign hashMap = new HashMapDesign();
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.get(1);
        hashMap.get(3);
        hashMap.put(2,1);
        hashMap.get(2);
        hashMap.remove(2);
        hashMap.get(2);
    }

    @Test
    public void testTestCase2() {
        HashMapDesign hashMap = new HashMapDesign();
        hashMap.remove(14);
        hashMap.get(4);
        hashMap.put(7, 3);
        hashMap.put(11, 1);
        hashMap.put(12, 1);
        hashMap.get(7);
        hashMap.put(1, 19);
        hashMap.put(0, 3);
        hashMap.put(1, 8);
        hashMap.put(2, 6);
    }
}
