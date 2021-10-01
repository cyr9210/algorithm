package com.bong.algorithm.programers.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Question01 {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        IntStream.range(0, progresses.length)
                .map(index -> getFinishDays(progresses[index], speeds[index]))
                .reduce((a, b) -> {
                    if (a > b) {
                        queue.offer(a);
                        return a;
                    }
                    answerList.add(queue.size());
                    queue.clear();
                    queue.offer(b);
                    return b;
                });

        if (queue.size() > 0) {
            answerList.add(queue.size());
        }

        return answerList.stream().mapToInt(answer -> answer).toArray();
    }

    private int getFinishDays(int progress, int speed) {
        int remain = 100 - progress;
        boolean isExact = (remain % speed) == 0;
        int days = remain / speed;
        if (isExact) {
            return days;
        }
        return ++days;
    }

    public static void main(String[] args) {
        //[93, 30, 55]|[1, 30, 5]
        //[95, 90, 99, 99, 80, 99]|[1, 1, 1, 1, 1, 1]|[1, 3, 2]
        Question01 question01 = new Question01();


        int[] result = question01.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
