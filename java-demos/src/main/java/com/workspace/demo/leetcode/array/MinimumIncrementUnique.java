package com.workspace.demo.leetcode.array;


import java.util.*;

/*
945. Minimum Increment to Make Array Unique
Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 */
public class MinimumIncrementUnique {

    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> duplicates = new ArrayList<>();
        Queue<Integer> available = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                duplicates.add(nums[i]);
            else {
                int curr = nums[i - 1] + 1;
                while (curr < nums[i]) {
                    available.add(curr++);
                }
            }
        }
        int increments = 0;
        int lastAvailableValue =-1;
        int lastValue = nums[nums.length-1];
        for (int d : duplicates) {
            while(!available.isEmpty() && lastAvailableValue <= d)
                lastAvailableValue = available.poll();
            if(lastAvailableValue <= d) {
                lastAvailableValue = ++lastValue;
            }
            increments += (lastAvailableValue - d);
            lastAvailableValue = -1;
        }
        return increments;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 2, 1, 4};
        int[] nums = new int[]{0,2,2,2};
        int count = minIncrementForUnique(nums);
        System.out.println("count = " + count);
    }
}
