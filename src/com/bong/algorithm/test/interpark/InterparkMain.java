package com.bong.algorithm.test.interpark;

public class InterparkMain {

    public static void main(String[] args) {
        testSolution01();
        testSolution02();
    }

    private static void testSolution01() {
        int speed_limit_case1 = 60;
        int[][] cameras_case1 = {{60, 1}, {130, 2}, {240, 4}, {432, 7}};

        int speed_limit_case2 = 30;
        int[][] cameras_case2 = {{60, 3}, {152, 6}, {240, 9}};

        Solution01 solution01 = new Solution01();
        int result1 = solution01.solution(speed_limit_case1, cameras_case1);
        int result2 = solution01.solution(speed_limit_case2, cameras_case2);

        System.out.println(String.format("expected:%s, actual:%s", 2, result1));
        System.out.println(String.format("expected:%s, actual:%s", 1, result2));
    }

    private static void testSolution02() {
        String sentence01 =
                "His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam.";
        String sentence02 =
                "Jackdaws love my big sphinx of quartz";
        String expected01 = "bjkqvwxz";
        String expected02 = "perfect";

        Solution02 solution02 = new Solution02();
        String result01 = solution02.solution(sentence01);
        String result02 = solution02.solution(sentence02);

        System.out.println(String.format("expected:%s, actual:%s", expected01, result01));
        System.out.println(String.format("expected:%s, actual:%s", expected02, result02));
    }
}
