package com.workspace.demo.leetcode.array;

/*
LC 35
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
         Example 1:

         Input: nums = [1,3,5,6], target = 5
         Output: 2
         Example 2:

         Input: nums = [1,3,5,6], target = 2
         Output: 1
         Example 3:

         Input: nums = [1,3,5,6], target = 7
         Output: 4
*/
public class SearchInsertPosition {

    // Modified binary search
    private static int findElementIdx(int[] input, int start, int end, int k) {
        if(input[start]>k)
           return start;
        if(input[end]<k)
            return end+1;
        int mid = (start + end) / 2;
        if (input[mid] == k)
            return mid;
        if (input[mid] > k) {
            return findElementIdx(input, start, mid - 1, k);
        }
        return findElementIdx(input, mid + 1, end, k);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 6, 9, 11, 14};
        int idx = findElementIdx(input, 0, input.length-1, 4);
        System.out.println("idx = " + idx);
    }
}
