package com.workspace.demo.companies.google;

public class TwoSumExists {

  private static int[] findIndices(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      int rem = target - nums[i];
      for (int j = i + 1; j < nums.length; j++)
        if (nums[j] == rem) {
          return new int[]{i, j};
        }
    }
    return new int[]{-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 13;
    int[] out = findIndices(nums, target);
    System.out.printf("[%d, %d]", out[0], out[1]);
  }
}
