package com.bichel.algorithms.probleamsheap;

import java.util.List;
import com.bichel.algorithms.problemsheap.CombinationSum;
import org.junit.jupiter.api.Test;

class CombinationSumTests {
    @Test
    void test1() {
        CombinationSum pr = new CombinationSum();
        List<List<Integer>> results = pr.combinationSum(new int[]{2,3,6,7}, 7);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> result: results) {
            for(int item: result) {
                sb.append(item).append(",");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
