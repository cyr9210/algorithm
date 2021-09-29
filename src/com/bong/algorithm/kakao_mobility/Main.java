package com.bong.algorithm.kakao_mobility;

public class Main {

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        String result = solution01.solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "Example");
        System.out.println(result);

        Solution02 solution02 = new Solution02();
        int result02 = solution02.solution(new int[]{3, 2, 3, 2, 3});
        System.out.println(result02);

        Solution03 solution03 = new Solution03();
        int result03 = solution03.solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0});
        System.out.println(result03);
    }
}