package com.bichel.other.Strings;

import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] D = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            D[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            D[0][i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int insertion = D[i][j - 1] + 1;
                int deletion = D[i - 1][j] + 1;
                int match = D[i - 1][j - 1];
                int mismatch = D[i - 1][j - 1] + 1;

                int min = insertion;
                if (min > deletion) {
                    min = deletion;
                }

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    if (min > match) {
                        min = match;
                    }
                } else {
                    if (min > mismatch) {
                        min = mismatch;
                    }
                }

                D[i][j] = min;
            }
        }

        return D[n][m];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
