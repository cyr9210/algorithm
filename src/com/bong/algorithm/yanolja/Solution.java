package com.bong.algorithm.yanolja;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String G) {
        // write your code in Java SE 8
        Map<Character, Integer> result = new HashMap<>();
        result.put('R', 0);
        result.put('S', 0);
        result.put('P', 0);

        char[] chars = G.toCharArray();
        for (char aChar : chars) {
            result.computeIfPresent(aChar, (character, integer) -> integer + 1);
        }

        int rPoint = getRPoint(result);
        int sPoint = getSPoint(result);
        int ppoint = getPpoint(result);

        return Math.max(Math.max(rPoint, sPoint), ppoint);
    }

    private int getRPoint(Map<Character, Integer> result) {
        int tie = result.get('R') * 1;
        int win = result.get('S') * 2;
        return tie + win;
    }

    private int getSPoint(Map<Character, Integer> result) {
        int tie = result.get('S') * 1;
        int win = result.get('P') * 2;
        return tie + win;
    }

    private int getPpoint(Map<Character, Integer> result) {
        int tie = result.get('P') * 1;
        int win = result.get('R') * 2;
        return tie + win;
    }

}
