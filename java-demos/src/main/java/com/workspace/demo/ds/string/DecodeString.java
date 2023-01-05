package com.workspace.demo.ds.string;


import java.util.Collection;
import java.util.Stack;


/*
LC 394. Decode String

Input: s = "3[a2[c]]"
Output: "accaccacc"

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */
public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                int multiplier = extractNumber(stack);
                String decoded = decode(temp.toString(), multiplier);
                for (char d : decoded.toCharArray())
                    stack.add(d);
            } else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    private static int extractNumber(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && Character.isDigit(stack.peek()))
            sb.append(stack.pop());
        return Integer.parseInt(sb.reverse().toString());
    }

    private static String decode(String s, int count) {
        StringBuilder sb = new StringBuilder();
        while (count-- != 0) {
            sb.append(s);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String input = "3[a2[c]]";
//        String input = "2[abc]3[cd]ef";
        String input = "10[ab]";
        String output = decodeString(input);
        System.out.println("output = " + output);
    }
}

