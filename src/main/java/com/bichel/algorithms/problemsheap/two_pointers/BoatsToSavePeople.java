package com.bichel.algorithms.problemsheap.two_pointers;

import java.util.Arrays;

/*
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time, provided the sum of the weight
of those people is at most limit.

Return the minimum number of boats to carry every given person.

Time Complexity: O(NlogN), where NN is the length of people.
Space Complexity: O(N)
 */

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        //the lightest persons
        int i = 0;
        //the heaviest persons
        int j = people.length - 1;

        int num = 0;

        while (i <= j) {
            num++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return num;
    }
}
