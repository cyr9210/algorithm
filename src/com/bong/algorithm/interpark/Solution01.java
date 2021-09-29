package com.bong.algorithm.interpark;

public class Solution01 {

    public int solution(int speed_limit, int[][] cameras) {
        int startPosition = 0;
        int startTime = 0;
        int speedingCount = 0;
        for (int i = 0; i < cameras.length; i++) {
            int endPosition = cameras[i][0];
            int distance = endPosition - startPosition;
            int endTime = cameras[i][1];
            int elapsedTime = endTime - startTime;

            if (((double) distance / elapsedTime) > speed_limit) {
                speedingCount++;
            }
            startPosition = endPosition;
            startTime = endTime;
        }
        return speedingCount;
    }

}
