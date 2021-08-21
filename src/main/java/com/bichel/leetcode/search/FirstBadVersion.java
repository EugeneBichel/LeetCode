package com.bichel.leetcode.search;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version.
You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
 */

public class FirstBadVersion {
    public int firstBadVersion(int n) {

        int l = 1;
        int r = n;
        int version = Integer.MAX_VALUE;
        int pivot = -1;

        while(l <= r) {
            pivot = l + (r-l) / 2;
            if(isBadVersion(pivot)) {
                if(pivot < version) version = pivot;
                r = pivot - 1;
            } else l = pivot + 1;
        }

        return version;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
