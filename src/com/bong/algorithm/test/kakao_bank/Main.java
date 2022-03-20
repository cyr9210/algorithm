package com.bong.algorithm.test.kakao_bank;

public class Main {

    public static void main(String[] args) {

        String[] request = new String[]{"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
        Solution01 solution01 = new Solution01();
        int result = solution01.solution(request);
        System.out.println(result);

        String[] request2 = new String[]{"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
        Solution01 solution1_2 = new Solution01();
        int result2 = solution1_2.solution(request2);
        System.out.println(result2);

        int[] request3 = new int[]{1, 1, 2, 0};
        Solution02 solution02 = new Solution02();
        int[] result3 = solution02.solution(request3);
        System.out.println("1-----------");
        for (int i : result3) {
            System.out.println(i);
        }

        int[] request4 = new int[]{1, 1, 1};
        Solution02 solution02_2 = new Solution02();
        int[] result4 = solution02_2.solution(request4);
        System.out.println("2------------");
        for (int i : result4) {
            System.out.println(i);
        }
    }


}
