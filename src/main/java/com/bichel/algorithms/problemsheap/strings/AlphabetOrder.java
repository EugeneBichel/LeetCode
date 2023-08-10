package com.bichel.algorithms.problemsheap.strings;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AlphabetOrder {

    class Pair {
        int num;
        char ch;

        public Pair(){}
        public Pair(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }

        public int getNum() {return this.num;}
        public char getCh() {return this.ch;}
    }

    public boolean isAlienSorted(String[] words, String order) {
        List<Character> letters = new ArrayList<>();

        for(char ch: order.toCharArray()) {
            letters.add(ch);
        }

        AtomicInteger index = new AtomicInteger();
        Map<Character, Integer> alphabet = letters.stream()
                .map(letter -> new Pair(index.getAndIncrement(), letter))
                .collect(Collectors.toMap(Pair::getCh, Pair::getNum));


        for(int i = 1; i < words.length; i++) {
            if(!isW1BeforeW2(words[i-1], words[i], alphabet)) {
                return false;
            }
        }

        return true;
    }

    private boolean isW1BeforeW2(String w1, String w2, Map<Character, Integer> alphabet) {
        int size = Math.min(w1.length(), w2.length());

        for (int i = 0; i < size; i++) {
            int kw1 = alphabet.get(w1.charAt(i));
            int kw2 = alphabet.get(w2.charAt(i));

            if (kw1 > kw2) {
                return false;
            } else if(kw1 < kw2) {
                return true;
            }
        }

        return w1.length() <= w2.length();
    }
}
