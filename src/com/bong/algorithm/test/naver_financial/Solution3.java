package com.bong.algorithm.test.naver_financial;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3 {

    public int solution(int[] A, int K) {
        // write your code in Java SE 8
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        int result = getAmplitude(copyList(list));
        for (int i = 0; i <= list.size() - K; i++) {
            List<Integer> copyList = copyList(list);
            for (int j = i; j < i+K; j++) {
                copyList.remove(i);
            }
            int amplitude = getAmplitude(copyList);
            result = Math.min(result, amplitude);
        }
        return result;
    }

    private int getAmplitude(List<Integer> list) {
        Collections.sort(list);
        int amplitude = list.get(list.size() - 1) - list.get(0);
        return amplitude;
    }

    private List<Integer> copyList(List<Integer> list) {
        return list.stream().collect(Collectors.toList());
    }


}
