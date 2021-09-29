package com.bong.algorithm.toss;

public class Question6 {

    public long solution(int numOfStairs) {
        int answer = 0;
        return getAnswer(numOfStairs, answer);
    }

    private int getAnswer(int numOfStairs, int answer) {
        for (int i = 1; i <= 3; i++) {
            if (numOfStairs >= i) {
                int remainStair = numOfStairs - i;
                if (remainStair == 0) {
                    answer++;
                } else {
                    answer = getAnswer(remainStair, answer);
                }
            }
        }
        return answer;
    }
}
