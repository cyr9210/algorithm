package com.bong.algorithm.test.naver_financial;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Consumer;

public class Solution2 {

    public int solution(String S) {
        String[] elements = S.split(" ");
        CustomStack customStack = new CustomStack();
        for (String element : elements) {
            try {
                customStack.push(element);
            } catch (Exception e) {
                return -1;
            }
        }
        return customStack.getResult();
    }

    public static class CustomStack {
        Stack<Integer> stack = new Stack<>();

        public void push(String element) {
            Operation operation = Operation.find(element);
            if (operation != null) {
                operation.operate(stack);
            } else {
                stack.push(Integer.parseInt(element));
            }
        }

        public int getResult() {
            return stack.pop();
        }
    }


    public enum Operation {
        PLUS("+", stack -> {
            int firstNum = stack.pop();
            int secondNum = stack.pop();
            stack.push(firstNum + secondNum);
        }),
        MINUS("-", stack -> {
            int firstNum = stack.pop();
            int secondNum = stack.pop();
            int result = firstNum - secondNum;
            if (result < 0) {
                throw new RuntimeException();
            }
            stack.push(result);
        }),
        DUP("DUP", stack -> {
            stack.push(stack.peek());
        }),
        POP("POP", stack -> {
            stack.pop();
        });

        private String letter;
        private Consumer<Stack<Integer>> expression;

        Operation(String letter, Consumer<Stack<Integer>> expression) {
            this.letter = letter;
            this.expression = expression;
        }

        public String getLetter() {
            return letter;
        }

        public static Operation find(String element) {
            return Arrays.stream(Operation.values())
                    .filter(o -> element.equals(o.getLetter()))
                    .findAny().orElse(null);
        }

        public void operate(Stack<Integer> stack) {
            expression.accept(stack);
        }

    }

}
