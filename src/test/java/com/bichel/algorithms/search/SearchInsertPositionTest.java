package com.bichel.algorithms.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsertPositionTest {
    @Test
    public void testTestCase1() {
        SearchInsertPosition pr = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 5;

        int actualPos = pr.searchInsert(nums, target);

        assertEquals(2, actualPos);
    }
}
