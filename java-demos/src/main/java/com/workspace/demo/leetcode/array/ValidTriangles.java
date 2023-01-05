package com.workspace.demo.leetcode.array;

import java.util.Arrays;

public class ValidTriangles {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int idx = findIndexUsingBinSearch(nums, j + 1, nums.length - 1, nums[i] + nums[j]);
//                if (idx != -1 && idx != j)
                    count += idx - j;
            }
            System.out.println("Count after processing " + nums[i] + " : " + count);
        }
        return count;
    }

    private static int findIndexUsingBinSearch(int[] nums, int start, int end, int target) {
        if (nums[end] < target)
            return end;
        if (nums[start] >= target)
            return start - 1;
        int mid = (start + end) / 2;

        if (nums[mid] >= target)
            return findIndexUsingBinSearch(nums, start, mid - 1, target);
        return findIndexUsingBinSearch(nums, mid + 1, end, target);
    }

    public static int binarySearch(int[] nums, int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

//
//
//    private static int findIndexUsingBinSearch2(int[] nums, int start, int end, int target) {
//        while(start<end) {
//         int mid = (start+end)/2;
//
//         if(nums[mid]>=target)
//             end = mid;
//         else start = mid+1;
//
//        }
//        return start;
//    }

    public static void main(String[] args) {
//        int[] input = new int[]{2, 2, 3, 4};
//        int[] input = new int[]{4, 2, 3, 4};
        int[] input = new int[]{24, 3, 82, 22, 35, 84, 19};
//        int[] input = new int[]{3,82,84};
        int output = triangleNumber(input);
        System.out.println("output = " + output);
    }
}
//    Count after processing 3 : 2
//        Count after processing 19 : 6
//        Count after processing 22 : 8
//        Count after processing 24 : 9
//        Count after processing 35 : 10
//        output = 10

//    Count after processing 3 : 2
//        Count after processing 19 : 5
//        Count after processing 22 : 7
//        Count after processing 24 : 8
//        Count after processing 35 : 9