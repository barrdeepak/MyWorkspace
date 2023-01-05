package com.workspace.demo.leetcode.array;

public class SearchRotatedArray {

    public static int search(int[] nums, int target) {

        if(nums.length == 1)
            return nums[0]==target?0:-1;
        int rotationIdx = findIdx(nums, 0, nums.length - 1);

        if(rotationIdx == -1)
            return binSearch(nums, 0, nums.length-1, target);
        int idx = binSearch(nums, 0, rotationIdx - 1, target);
        if (idx == -1)
            idx = binSearch(nums, rotationIdx, nums.length - 1, target);
        return idx;
    }

    public static int binSearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return binSearch(nums, start, mid - 1, target);
        else return binSearch(nums, mid + 1, end, target);
    }

    public static int findIdx(int[] nums, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1])
            return mid + 1;
        else if (nums[mid] > nums[start])
            return findIdx(nums, mid + 1, end);
        else return findIdx(nums, start, mid - 1);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
//        int[] nums = new int[]{1,3};
        int[] nums = new int[]{5,1,3};


        int idx = search(nums, 5);
        System.out.println("idx = " + idx);
    }
}
