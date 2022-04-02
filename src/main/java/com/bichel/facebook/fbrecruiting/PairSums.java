package com.bichel.facebook.fbrecruiting;

import java.util.HashSet;
import java.util.Set;

public class PairSums {
    class Pair {
        public int l;
        public int r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (l != pair.l) return false;
            return r == pair.r;
        }

        @Override
        public int hashCode() {
            int result = l;
            result = 31 * result + r;
            return result;
        }
    }

    private Set<Pair> s;
    public int numberOfWays(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        s = new HashSet<>();

        trace(arr, k, l, r);

        return s.size();
    }

    private void trace(int[] arr, int k, int l, int r) {
        if (l >= r) return;

        if (s.contains(new Pair(l, r))) return;

        if (arr[l] + arr[r] == k) {
            s.add(new Pair(l, r));
        }

        trace(arr, k, l + 1, r);
        trace(arr, k, l, r - 1);
    }
}
