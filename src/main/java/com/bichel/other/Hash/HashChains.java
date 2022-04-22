package com.bichel.other.Hash;

import java.io.*;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // for hash function
    private long bucketCount;
    private long prime = 1000000007;
    private long multiplier = 263;
    private HashMap<Long, List<String>> hashMap = new HashMap<Long, List<String>>();

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private long hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            Long ind = (long)in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {

        long key;

        switch (query.type) {
            case "add":
                key = hashFunc(query.s);
                List<String> l = hashMap.get(key);
                if(l == null) {
                    l = new LinkedList<>();
                }
                if(!l.contains(query.s)) {
                    l.add(query.s);
                }
                hashMap.put(key, l);
                break;
            case "del":
                key = hashFunc(query.s);
                l = hashMap.get(key);
                if(l != null) {
                    l.remove(query.s);
                }
                break;
            case "find":
                key = hashFunc(query.s);
                l = hashMap.get(key);
                if(l != null) {
                    writeSearchResult(l.contains(query.s));
                } else {
                    writeSearchResult(false);
                }
                break;
            case "check":
                l = hashMap.get(query.ind);
                if(l != null) {
                    for (int i = l.size() - 1; i >= 0; i--)
                        out.print(l.get(i) + " ");
                }

                out.println();
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        Long ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, Long ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
