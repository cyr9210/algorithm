package com.bong.algorithm.test.interpark;

import java.util.HashSet;
import java.util.Set;

public class Solution02 {

    public String solution(String sentence) {
        StringBuilder builder = new StringBuilder();

        Set<Character> sentenceSet = new HashSet<>();
        char[] sentenceChars = sentence.toLowerCase().toCharArray();
        for (char sentenceChar : sentenceChars) {
            sentenceSet.add(sentenceChar);
        }

        for(char c = 'a'; c <= 'z'; c++) {
            if (!sentenceSet.contains(c)) {
                builder.append(c);
            }
        }

        if (builder.length() == 0) {
            return "perfect";
        }
        return builder.toString();
    }

}
