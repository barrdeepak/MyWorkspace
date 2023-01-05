package com.workspace.demo.leetcode.stack;


import java.util.Stack;

/*
LC 739. Daily Temperatures

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        stack.push(temperatures[0]);
        for (int i = 1; i < temperatures.length; i++) {

            if(stack.peek()> temperatures[i]) {

            }

        }
        return result;
    }

    public static void main(String[] args) {

        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] output = dailyTemperatures(input);

        for (int i : input)
            System.out.print(i + "\t");
        System.out.println();

        for (int o : output)
            System.out.print(o + "\t");
        System.out.println();
    }
}
