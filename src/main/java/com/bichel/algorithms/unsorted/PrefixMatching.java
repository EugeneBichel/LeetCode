package com.bichel.algorithms.unsorted;

import java.util.ArrayList;

/*
Problem Description

We have a list of lexicographically sorted strings A. We also have a string B. We need the first and last indexes of strings from A which are having their prefix as B. A can contain duplicate strings.

Return [-1, -1] if no such prefix exists.
 */

public class PrefixMatching {
    public ArrayList<Integer> solve(ArrayList<String> A, String B) {

        ArrayList<Integer> ans = new ArrayList<>();
        int firstInd = -1;
        int lastInd = -1;

        for(int i=0; i<A.size(); i++) {
            if(A.get(i).startsWith(B)) {
                if(firstInd == -1) firstInd = i;
                else lastInd = i;
            }
        }

        if(firstInd != -1 && lastInd == -1) lastInd = firstInd;

        ans.add(firstInd);
        ans.add(lastInd);

        return ans;
    }
}
