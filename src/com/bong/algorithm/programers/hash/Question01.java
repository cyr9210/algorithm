package com.bong.algorithm.programers.hash;

import java.util.HashMap;
import java.util.Map;

public class Question01 {


    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> matchMap = new HashMap<>();
        for (String name : participant) {
            matchMap.computeIfPresent(name, (s, integer) -> ++integer);
            matchMap.putIfAbsent(name, 1);
        }

        for (String name : completion) {
            Integer count = matchMap.computeIfPresent(name, (s, integer) -> --integer);
            if (count == 0) {
                matchMap.remove(name);
            }
        }
        
        return String.join(" ", matchMap.keySet());
    }

}
