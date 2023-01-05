package com.workspace.demo.companies.google;

public class SumInArray {

  static void checkContineuousArraySum(int[] input, int sum) {

    int currSum = input[0];
    int start = 0, end = 0;
//    if (currSum == sum) {
//      System.out.printf("%s,  %s", start, end);
//      return;
//    }

    for (int i = 1; i < input.length; i++) {
      currSum += input[i];
      end = i;
      if (currSum > sum) {
        currSum -= input[start];
        start++;
      }
      if (currSum == sum) {
        System.out.printf("%s, %s", start, end);
        return;
      }
    }
    System.out.println("Sum does not exist");
  }


  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 5, 5, 8, 7, 3};
    int sum = 13;
    checkContineuousArraySum(input, sum);
  }
}
