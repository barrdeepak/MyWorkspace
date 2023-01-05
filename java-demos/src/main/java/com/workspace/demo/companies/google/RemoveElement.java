package com.workspace.demo.companies.google;

public class RemoveElement {

  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 5, 5, 8, 7, 3, 12, 15, 5};
    int toRemove = 5;
    removeElement(input, toRemove);
    UtilityFn.printArray(input);
  }

  private static int removeElement(int[] nums, int val) {
    int curr = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        if (curr != i) {
          nums[curr] = nums[i];
        }
        curr++;
      }
    }
    return curr;
  }
}
