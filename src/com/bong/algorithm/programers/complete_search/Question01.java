package com.bong.algorithm.programers.complete_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question01 {
    public int[] solution(int[] answers) {
        int[] markFirst = new int[]{1, 2, 3, 4, 5};
        int[] markSecond = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] markThird = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstScore = getScore(answers, markFirst);
        int secondScore = getScore(answers, markSecond);
        int thirdScore = getScore(answers, markThird);

        List<Integer> list = Arrays.asList(firstScore, secondScore, thirdScore);
        int max = list.stream().max(Integer::compareTo).get();

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                answerList.add(i);
            }
        }

        return answerList.stream().mapToInt(index -> index + 1).toArray();
    }

    public int[] solution2(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        List<Integer> scoreList = Arrays.stream(patterns)
                .map(pattern -> getScore(answers, pattern))
                .collect(Collectors.toList());

        int max = scoreList.stream().max(Integer::compareTo).get();

        return IntStream.range(0, scoreList.size())
                .filter(i -> scoreList.get(i).equals(max))
                .map(i -> i+1)
                .toArray();
    }

    private int getScore(int[] answers, int[] pattern) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Question01 question01 = new Question01();
        int[] result = question01.solution(new int[]{1, 3, 2, 4, 2});
        for (int r : result) {
            System.out.println(r);
        }
    }
}
