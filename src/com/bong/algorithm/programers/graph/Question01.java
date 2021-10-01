package com.bong.algorithm.programers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Question01 {

    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        
        Arrays.stream(edge)
                .forEach(array -> {
                    map[array[0]].add(array[1]);
                    map[array[1]].add(array[0]);
                });

//        2차배열
//        int[][] map2 = new int[n + 1][n + 1];
//        Arrays.stream(edge)
//                .forEach(array -> {
//                    map2[array[0]][array[1]] = 1;
//                    map2[array[1]][array[0]] = 1;
//                });

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);
        int max = 0;
        while (!nodes.isEmpty()) {
            int start = nodes.poll();
            for (int point : map[start]) {
                if (dist[point] == 0 && point != 1) {
                    dist[point] = dist[start] + 1;
                    nodes.add(point);
                    max = Math.max(max, dist[point]);
                }
            }
        }

        int count = 0;
        for (int i : dist) {
            if (i == max) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Question01 question01 = new Question01();
        int result = question01.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(result);
    }
}
