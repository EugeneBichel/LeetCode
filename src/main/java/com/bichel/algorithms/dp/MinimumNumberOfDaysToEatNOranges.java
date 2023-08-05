package com.bichel.algorithms.dp;

/*
There are n oranges in the kitchen and you decided to eat some of these oranges
every day as follows:

Eat one orange.
If the number of remaining oranges n is divisible by 2 then you can eat n / 2 oranges.
If the number of remaining oranges n is divisible by 3 then you can eat 2 * (n / 3) oranges.
You can only choose one of the actions per day.

Given the integer n, return the minimum number of days to eat n oranges.
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfDaysToEatNOranges {
    private Map<Integer, Integer> dp = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1)
            return n;

        if (!dp.containsKey(n))
            dp.put(n,
                    1 + Math.min(n % 2 + minDays(n / 2),
                            n % 3 + minDays(n / 3))
            );

        return dp.get(n);
    }
}
