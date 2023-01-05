package com.workspace.demo.leetcode.stack;


import java.util.Stack;

public class ValidateStackOperationSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        if (pushed.length == 0)
            return true;

        Stack<Integer> stack = new Stack();
        int i = 1, j = 0;
        stack.push(pushed[0]);
        while (i<pushed.length) {
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            stack.push(pushed[i++]);
        }
        while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
//        int[] popped = new int[]{4, 3, 5, 1, 2};
        boolean result = validateStackSequences(pushed, popped);
        System.out.println("result = " + result);
    }
}
