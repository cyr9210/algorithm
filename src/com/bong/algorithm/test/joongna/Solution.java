package com.bong.algorithm.test.joongna;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(3, new String[]{"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110", "coco 250", "cheries2 301"});
        System.out.println(result);

        int result2 = solution.solution(3, new String[]{"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"});
        System.out.println(result2);

        int result3 = solution.solution(2, new String[]{"cheries2 200", "alex111 100", "coco 150", "puyo 120", "puyo 200", "cheries2 201"});
        System.out.println(result3);
    }

    public int solution(int k, String[] input) {
        Map<String, Integer> scoreMap = new HashMap<>();
        PriorityQueue<String> rankScore = new PriorityQueue<>(Comparator.comparingInt(scoreMap::get));
        int count = 0;

        for (String s : input) {
            List<String> before = rankScore.stream()
                    .sorted(Comparator.comparingInt(scoreMap::get))
                    .collect(Collectors.toList());

            String name = s.substring(0, s.indexOf(SPACE));
            Integer score = Integer.valueOf(s.substring(s.indexOf(SPACE) + 1));

            scoreMap.putIfAbsent(name, score);
            if (score > scoreMap.get(name)) {
                scoreMap.put(name, score);
            }

            if (rankScore.size() < k) {
                rankScore.add(name);
            }

            if (!rankScore.contains(name) && score > scoreMap.get(rankScore.peek())) {
                rankScore.add(name);
            }

            while (rankScore.size() > 3) {
                rankScore.poll();
            }

            List<String> current = rankScore.stream()
                    .sorted(Comparator.comparingInt(scoreMap::get))
                    .collect(Collectors.toList());

            if (!isEquals(before, current, current.size())) {
                count++;
            }
        }

        return count;
    }

    private boolean isEquals(List<String> before, List<String> current, int k) {
        if (before.size() != current.size()) {
            return false;
        }

        for (int i = 0; i < k; i++) {
            if (!before.get(i).equals(current.get(i))) {
                return false;
            }
        }
        return true;
    }
}
