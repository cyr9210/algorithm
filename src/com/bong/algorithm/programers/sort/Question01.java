package com.bong.algorithm.programers.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question01 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = Arrays.stream(commands)
                .map(command -> getAnswer(array, command[0] - 1, command[1], command[2] - 1))
                .mapToInt(number -> number)
                .toArray();
        return answer;
    }

    private int getAnswer(int[] array, int startIndex, int endIndex, int peak) {
        List<Integer> list = IntStream.range(startIndex, endIndex)
                .map(i -> array[i]).sorted().boxed()
                .collect(Collectors.toList());
        return list.get(peak);
    }

    public static void main(String[] args) {
        Question01 question01 = new Question01();
        int[] solution = question01.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : solution) {
            System.out.println(i);
        }
    }

}
