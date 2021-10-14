package com.bichel.leetcode.combinations_permutations;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationsTest {

    @Test
    public void testPermutations() {

//        Integer.MAX_VALUE
        //Math.abs()

        Map<Character, Character> map = new HashMap<>();
        //map.put()
        //map.containsKey()

        String s = "123";
        //s.charAt().
        //s.length()
        //s.charAt()

        int[] nums = {1, 2, 3, 4};

        IntStream.of(nums).boxed()
                .map(val -> val * val)
                .sorted(Comparator.reverseOrder())
                .toArray();

        int lengthOfWord = 5;

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        final double numberOfPermutations = Math.pow(vowels.length, lengthOfWord);

        List<String> words = new ArrayList<>(Double.valueOf(numberOfPermutations).intValue());

        char[] temp = new char[lengthOfWord];
        Arrays.fill(temp, '0');

        for (int i = 0; i < numberOfPermutations; i++) {
            int n = i;
            for (int k = 0; k < lengthOfWord; k++) {
                temp[k] = vowels[n % vowels.length];
                n /= vowels.length;
            }

            words.add(String.valueOf(temp));
        }

        words.forEach(word -> System.out.print(word + ", "));
    }

    @Test
    public void test() {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url =
                    new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                String result = new BufferedReader(new InputStreamReader(inputStream))
                        .lines().parallel().collect(Collectors.joining("\n"));

                int s = result.indexOf("[");
                int e = result.indexOf("]");

                System.out.println(inputStream);
            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}
