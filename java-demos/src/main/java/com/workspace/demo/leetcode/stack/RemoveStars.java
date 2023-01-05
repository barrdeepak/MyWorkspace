package com.workspace.demo.leetcode.stack;

import java.util.Collections;
import java.util.Stack;

/* LC 2390. Removing Stars From a String
Input: s = "leet**cod*e"
Output: "lecoe"

Input: s = "erase*****"
Output: ""
 */
public class RemoveStars {

    private static String removeStars(String s) {
        Stack<Character> stack = new Stack();
        for(char c:s.toCharArray()) {
            if(c =='*')
                stack.pop();
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String input = "leet**cod*e";
         String input = "erase*****";
        String output = removeStars(input);
        System.out.println("output = " + output);
    }
}
