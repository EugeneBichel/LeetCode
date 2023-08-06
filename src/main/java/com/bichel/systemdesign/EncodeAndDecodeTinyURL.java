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

public class EncodeAndDecodeTinyURL {
    private Map<Integer, String> map = new HashMap<>();
    private int i = 0;

    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
