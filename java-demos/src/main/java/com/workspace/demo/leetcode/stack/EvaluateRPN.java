package com.workspace.demo.leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateRPN {

    private static int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+","-","*","/"));
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if(operators.contains(s)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        break;
                }
            } else stack.push(Integer.parseInt(s));
            }
        return stack.pop();
        }

    public static void main(String[] args) {
//        String[] input = new String[]{"2", "1", "+", "3", "*"};
        String[] input = new String[]{"4","13","5","/","+"};
        int result = evalRPN(input);
        System.out.println("result = " + result);
    }
}
