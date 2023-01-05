package com.workspace.demo.leetcode.stack;


import java.util.Stack;

//LC 678. Valid Parenthesis String ||

//Not correct - Need to use DP or greedy algo
public class ValidParenthesis {

    private static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack();
        int[] counts = new int[3];
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    counts[0]++;
                    break;
                case ')':
                    counts[1]++;
                    break;
                case '*':
                    counts[2]++;
                    break;
                default:
                    break;
            }
        }

        int diff = counts[0] - counts[1];

        for (char c : s.toCharArray()) {
            if(c == '*') {
                if (diff < 0) {
                    c = '(';
                    diff++;
                } else if(diff > 0) {
                    c = ')';
                    diff--;
                }
                else continue;
            }
            if (c == '(')
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "**))";
        boolean result = checkValidString(input);
        System.out.println("result = " + result);
    }
}
