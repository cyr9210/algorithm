package com.bong.algorithm.test.kakao_mobility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution03 {

    public int solution(int[] T, int[] A) {
        Map<Integer, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            skillMap.put(i, T[i]);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : A) {
            int beforeSkill = i;
            result.add(i);
            while (beforeSkill != 0) {
                int skill = skillMap.get(beforeSkill);
                result.add(skill);
                beforeSkill = skill;
            }
        }
        return result.size();
    }



}
