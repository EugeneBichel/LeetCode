package com.bichel.hackerrank;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
      Map<String, Integer> map = new HashMap<>();
      map.entrySet().stream()
              .map(Map.Entry::getKey)
              .collect(Collectors.toList());
    }
}
