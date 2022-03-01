package com.bichel.facebook;

/*
You are given a sorted unique integer array nums.
Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
That is, each element of nums is covered by exactly one of the ranges,
and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:
"a->b" if a != b
"a" if a == b

Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Time complexity : O(n).
Each element is visited constant times: either in comparison with neighbor
or put in the result list.

Space complexity : O(1). All the auxiliary space we need is the two indices,
if we don't count the return list.
 */

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();

        for (int i = 0, j = 0; j < nums.length; j++) {

            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);

            i = j + 1;
        }

        return summary;
    }
}
