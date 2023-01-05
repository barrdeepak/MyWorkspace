package com.workspace.demo.leetcode.stack;


import java.util.Stack;

//LC 1047. Remove All Adjacent Duplicates In String
public class AdjacentDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {

            if(stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "azxxzy";
        String output = removeDuplicates(input);
        System.out.println("output = " + output);
    }
}
