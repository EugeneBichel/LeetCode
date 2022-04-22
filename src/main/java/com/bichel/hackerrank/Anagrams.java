package com.bichel.hackerrank;
import java.io.*;
import java.util.*;

public class Anagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();

        for(int j = 0; j < len; j++) {
            for(int i = j; i < len; i++) {
                String key = s.substring(i,i+1);

                if( !map.containsKey( key ) ) {
                    map.put(key, 0);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
        }

        return map.values().stream().reduce(0, Integer::sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
