package com.workspace.demo.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
1249. Minimum Remove to Make Valid Parentheses

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

 */

class Pair {
    char c;
    int index;
    public Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}

public class MinRemoveValidParenthesis {

    public static String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new Pair('(', i));
            } else {
                if (s.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek().c == '(')
                        stack.pop();
                    else stack.push(new Pair(')', i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> indices = new ArrayList<>();
        while(!stack.isEmpty()) {
            indices.add(stack.pop().index);
        }

        for (int i = 0; i < s.length(); i++) {
            if(!indices.contains(i))
                sb.append(s.charAt(i));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String input = "lee(t(c)o)de)";
//        String input  = "a)b(c)d";
//        String input  = "(a(b)cd";
//        String input = "(a)(bcd";
        String input = "))((";
        String output = minRemoveToMakeValid(input);
        System.out.println("output = " + output);
    }
}
