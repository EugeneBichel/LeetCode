package com.bichel.algorithms.combinations_permutations;

import com.bichel.algorithms.problemsheap.combinations_permutations.Permutations;
import org.junit.jupiter.api.Test;
import java.util.List;

class PermutationsTest {

    @Test
    void testPermutations() {
        Permutations program = new Permutations();

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> results = program.permute(nums);

        for(List<Integer> record: results) {
            StringBuilder sb = new StringBuilder();

            for(int item: record) {
                sb.append(item).append(", ");
            }

            System.out.println(sb);
        }

    }
}
