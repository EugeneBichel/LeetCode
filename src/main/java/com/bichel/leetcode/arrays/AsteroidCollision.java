package com.bichel.leetcode.arrays;

/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size,
and the sign represents its direction (positive meaning right,
negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet.
 */

import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            if (i > 0)
                s.add(i);
            else {
                while (!s.isEmpty() &&
                        s.getLast() > 0 &&
                        s.getLast() < -i)
                    s.pollLast();
                if (!s.isEmpty() && s.getLast() == -i)
                    s.pollLast();
                else if (s.isEmpty() || s.getLast() < 0)
                    s.add(i);
            }
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}
