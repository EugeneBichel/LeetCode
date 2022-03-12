package com.bichel.facebook;

/*
A string can be abbreviated by replacing any number of non-adjacent,
non-empty substrings with their lengths. The lengths should not have leading zeros.
For example, a string such as "substitution" could be abbreviated as (but not limited to):
"s10n" ("s ubstitutio n")
 */

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }

        return i == word.length() && j == abbr.length();
    }
}
