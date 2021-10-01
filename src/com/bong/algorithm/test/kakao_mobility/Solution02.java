package com.bong.algorithm.test.kakao_mobility;

public class Solution02 {

    //짝수 위치의 모든 숫자가 같고 홀수 위치의 모든 숫자가 같으면 스위칭이라고한다.
    //주어진 배열 A에서 최대 스위칭 길이를 반환.
    public int solution(int[] A) {
        if ( A.length == 1 || A.length == 2 ) {
            return A.length;
        }

        //init
        int length = 2;
        int maxLength = length;
        int odd = A[0];
        int even = A[1];

        for (int i = 2; i < A.length; i++) {
            if ( isOdd(i) ) {
                if ( odd == A[i] ) {
                    length++;
                } else {
                    maxLength = Math.max(maxLength, length);
                    length = 2;
                    odd = A[i];
                }
            } else {
                if ( even == A[i] ) {
                    length++;
                } else {
                    maxLength = Math.max(maxLength, length);
                    length = 2;
                    even = A[i];
                }
            }
        }

        maxLength = Math.max(maxLength, length);
        return maxLength;
    }

    private boolean isOdd(int index) {
        return index%2 == 0;
    }

}
