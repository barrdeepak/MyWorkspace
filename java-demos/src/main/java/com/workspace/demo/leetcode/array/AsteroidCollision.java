package com.workspace.demo.leetcode.array;


import java.util.Collections;
import java.util.Stack;

// LC 735. Asteroid Collision
public class AsteroidCollision {
    // This solution looks good but LC wants something different which is confusing
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty() || a*stack.peek()*a>0 )
                stack.push(a);
            else {
                while (Math.abs(stack.peek()) < Math.abs(a) && a * stack.peek() < 0) {
                    stack.pop();
                }
                if (Math.abs(stack.peek()) == Math.abs(a) && a * stack.peek() < 0)
                    stack.pop();
            }
        }
        Collections.reverse(stack);
        int[] output = new int[stack.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = stack.pop();
        }
        return output;
    }

    // This is for LC
    public static int[] asteroidCollisionLC(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty() || stack.peek() * a > 0 || a > 0)
                stack.push(a);
            else {
                while (stack.peek() < Math.abs(a) && a<0 && stack.peek()*a<0) {
                    stack.pop();
                }
                if (stack.peek() == Math.abs(a) && a<0 && stack.peek()*a>0)
                    stack.pop();
            }
        }
        Collections.reverse(stack);
        int[] output = new int[stack.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = stack.pop();
        }
        return output;
    }

    public static void main(String[] args) {

//        int[] input = new int[]{5, 10, -5};
//        int[] input = new int[]{10, 2, -5};
//          int[] input = new int[]{-2,-1,1,2};

        int[] input = new int[]{-2,-2,1, -2};

        int[] result = asteroidCollisionLC(input);
        for (int r : result)
            System.out.print(r + "\t");
        System.out.println();
    }
}
