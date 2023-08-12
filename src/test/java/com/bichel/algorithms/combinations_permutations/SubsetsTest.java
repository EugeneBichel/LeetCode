package com.bichel.algorithms.combinations_permutations;

import java.util.List;
import com.bichel.algorithms.problemsheap.combinations_permutations.Subsets;
import org.junit.jupiter.api.Test;

public class SubsetsTest {

    @Test
    void testSubsets() {
        Subsets program = new Subsets();
        List<List<Integer>> results = program.subsets(new int[]{1,2,3});

        for(List<Integer> result: results) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int item: result) {
                sb.append(item).append(", ");
            }
            sb.append("]");

            System.out.println(sb);
        }
    }
}
