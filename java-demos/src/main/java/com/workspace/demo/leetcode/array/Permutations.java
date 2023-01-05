package com.workspace.demo.leetcode.array;


import java.util.*;

/*
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        return permutations(nums, 0);
    }

    public static List<List<Integer>> permutations(int[] nums, int start) {
        Set<List<Integer>> result = new HashSet<>();
        if(start == nums.length - 1) {
            result.add(Arrays.asList(nums[start]));
        }

        for (int i = start; i < nums.length; i++) {
            int first = nums[start];
            List<List<Integer>> subResult = permutations(nums, start + 1);
            for(List<Integer> list : subResult)
            {
              for(int j =0 ; j <= list.size(); j++) {
                  List<Integer> newList = new ArrayList<>(list);
                  newList.add(j, first);
                  result.add(newList);
              }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        System.out.println("list = " + list);
//
//        list.add(3, 5);
//        System.out.println("list = " + list);
//
        List<List<Integer>> result = permute(nums);
        System.out.println("Output - ");
        for (List<Integer> r : result)
            System.out.println(r);
    }
}
