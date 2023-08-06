package com.bichel.systemdesign;

/*
TinyURL is a URL shortening service where you enter a URL
such as https://leetcode.com/problems/design-tinyurl
and it returns a short URL such as http://tinyurl.com/4e9iAk.
Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL
and the tiny URL can be decoded to the original URL.
 */

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL2 {
    private final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<String, String> map = new HashMap<>();
    private int count = 1;

    private String getString() {
        int c = count;
        StringBuilder sb = new StringBuilder();
        while (c > 0) {
            c--;
            sb.append(chars.charAt(c % 62));
            c /= 62;
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        String key = getString();
        map.put(key, longUrl);
        count++;
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
