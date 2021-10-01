package com.bong.algorithm.programers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Question01 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue
                = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        int count = 0;
        while (priorityQueue.peek() < K) {
            int min = priorityQueue.poll();
            int secondMin = priorityQueue.poll();
            int sum = min + (2 * secondMin);
            priorityQueue.add(sum);
            count++;
        }

        return count;
    }

    public void test(int[] scovile) {
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(9);
        s.add(10);
        s.add(12);

        int size = s.size();
        for (int i = 0; i < size; i++) {
            System.out.println(s.poll());
        }
    }

    public static void main(String[] args) {
        Question01 question01 = new Question01();
        int result = question01.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        question01.test(new int[]{1, 2, 3, 9, 10, 12});

        System.out.println("--------------");
        System.out.println(result);
    }
}
