package com.bong.algorithm.test.toss;

public class TossMain {

    public static void main(String[] args) {
        Question6 question6 = new Question6();
        long solution = question6.solution(4);
        System.out.println(String.format("expected:7, actual:%s", solution));

        Question6 question6_2 = new Question6();
        long solution2 = question6_2.solution(3);
        System.out.println(String.format("expected:4, actual:%s", solution2));

        Question6 question6_3 = new Question6();
        long solution3 = question6_3.solution(2);
        System.out.println(String.format("expected:2, actual:%s", solution3));
    }
}
