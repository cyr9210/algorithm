package com.bong.algorithm.yanolja;

import java.util.Arrays;

public class Solution4 {

    public int solution(String r1, String r2) {
        int[] r1First = take(r1, r2);
        int[] r2First = take(r2, r1);

        int noTurn = Math.max(count(r1, 0, r1.length()-1), count(r2, 0, r2.length()-1));
        int result = Math.max(maxOf(r1First),maxOf(r2First));

        System.out.println(Math.max(noTurn, result));
        return Math.max(noTurn, result);
    }

    private int[] take(String r1, String r2) {
        int[] results = new int[r1.length()];
        for ( int i = 0; i<r1.length(); i++ ) {
            int result = count(r1, i+1, r1.length()-1) + count(r2, 0,i-1);
            results[i] = result;
        }
        return results;
    }

    private int count(String road, int start, int end) {
        int count = 0;
        for (int i = start; i < end+1; i++) {
            if ( road.charAt(i) == 'x' ) {
                count++;
            }
        }
        return count;
    }

    private int maxOf(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

}
