package com.bong.algorithm.programers;

import com.bong.algorithm.programers.hash.Question01;

public class Main {

    public static void main(String[] args) {
        Question01 question01 = new Question01();
        String result = question01.solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"});
        System.out.println(result);
    }
}
