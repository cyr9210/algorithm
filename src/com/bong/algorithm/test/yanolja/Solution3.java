package com.bong.algorithm.test.yanolja;

import java.util.Arrays;

public class Solution3 {

    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i <= A.length; i++) {
            count += Math.abs(i - A[i-1]);
        }
        return count;
    }
}
