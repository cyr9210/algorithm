package com.bong.algorithm.test.naver_financial;

public class Solution {

    public int solution(String S) {
        if (S.contains("aaa")) {
            return -1;
        }

        char[] chars = S.toCharArray();
        int notACount = 0;
        int currentACount = 0;
        for (char aChar : chars) {
            if ('a' != aChar) {
                notACount++;
            } else {
                currentACount ++;
            }
        }
        int totalACount = (notACount + 1) * 2;
        return totalACount - currentACount;
    }
}
