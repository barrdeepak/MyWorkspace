package com.workspace.demo.leetcode.others;

/*
1323. Maximum 69 Number
Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.

 */
public class MaximumNumber {

    private static int maximum69Number(int num) {
        int highest = -1;
        int n = num;
        for (int i = 0; i < 6; i++) {
            int val = n % 10;
            n = n / 10;
            if (val == 6)
                highest = i;
        }
        if (highest == -1)
            return num;
        return (int) (num + (3 * Math.pow(10, highest)));
    }

    public static void main(String[] args) {
        int maxNum = maximum69Number(999);
        System.out.println("maxNum = " + maxNum);
    }
}
