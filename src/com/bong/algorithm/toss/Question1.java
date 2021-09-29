package com.bong.algorithm.toss;

public class Question1 {

    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        long productAmount = orderAmount - serviceFee - taxFreeAmount;
        if (productAmount == 1) {
            return 0;
        }


        double a = ((orderAmount - serviceFee - taxFreeAmount) / 1.1) * 0.1;
        return Math.round(a);
    }
}
