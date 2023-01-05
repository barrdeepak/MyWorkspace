package com.workspace.demo.companies.google;

import java.util.List;

public class UtilityFn {
  public static void printList(List<Integer> list) {
    for(Integer i:list)
      System.out.println(i);
  }

  public static void printArray(int[] arr) {
    for (int value : arr)
      System.out.print(value + " ");
    System.out.println();
  }
}
