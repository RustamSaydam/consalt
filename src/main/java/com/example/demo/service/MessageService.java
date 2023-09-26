package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class MessageService {
    public Map<Character, Integer> method(String str) {
        Map<Character, Integer> hashMap = new HashMap<>();
        char [] chars = str.toCharArray();
        for (char c: chars) {
            if (hashMap.get(c) != null) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else
                hashMap.put(c, 1);
        }
        hashMap = hashMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return hashMap;
    }

}
