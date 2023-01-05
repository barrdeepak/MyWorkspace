package com.workspace.demo.leetcode.array;

/*
 LC 163. Missing Ranges
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissingRange {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (lower < nums[i])
                    result.add(getString(lower - 1, nums[i]));
            } else result.add(getString(nums[i - 1], nums[i]));
        }
        result.add(getString(nums[nums.length - 1], upper + 1));
        return result.stream().filter(s -> s.length() != 0).collect(Collectors.toList());
    }

    private static String getString(int low, int high) {
        if (high - low == 1)
            return "";
        if (high - low == 2)
            return Integer.toString(low + 1);
        if (high - low > 2)
            return String.format("%s->%s", low + 1, high - 1);
        return "Invalid";
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
        List<String> result = findMissingRanges(nums, lower, upper);
        System.out.println("result = " + result);
    }
}
