package com.workspace.demo.leetcode.array;

/*
560. Subarray Sum Equals K
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 */

public class SubArrraySum {

    public static int subarraySum(int[] nums, int k) {
        int start = 0, end = 0, sum = nums[0];
        int count = 0;

        while (start <= end) {
            if (sum > k)
                sum -= nums[start++];
            else if (sum < k) {
                if (end < nums.length - 1)
                    sum += nums[++end];
                else sum -= nums[start++];
            } else if (sum == k) {
                count++;
                if (end < nums.length - 1)
                    sum += nums[++end];
                else sum -= nums[start++];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] input = new int[]{1,-1,0};
        int k = 0;
        int n = subarraySum(input, k);
        System.out.println("n = " + n);
    }
}
