package com.bichel.systemdesign;

public class StringIterator {
    public static void main(String[] args) {
        String compressedStr = "L10e2t1C1o1d1e1";
        StringIterator si = new StringIterator(compressedStr);
        si.next();
        si.next();
        si.next();
        si.next();
        si.next();
        si.next();
        si.hasNext();
        si.next();
        si.hasNext();
    }

    int ind = 0;
    char letter = ' ';
    int times = 0;
    char[] arr;
    String source;

    public StringIterator(String compressedString) {
        arr = compressedString.toCharArray();
        source = compressedString;
    }

    public char next() {
        if (times > 0) {
            times--;
            return letter;
        } else {

            if (ind > arr.length - 1) {
                return ' ';
            }

            if (hasNext()) {
                letter = arr[ind];
                int l = ind + 1;
                int r = l;

                while (r < arr.length && Character.isDigit(arr[r]))
                    r++;

                times = Integer.parseInt(source.substring(l, r));
                times--;
                ind = r; // char + integer

                return letter;
            } else {
                return ' ';
            }
        }
    }

    public boolean hasNext() {
        if (ind + 1 < arr.length || times > 0) {
            return true;
        } else {
            return false;
        }
    }
}
