package com.workspace.demo.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]!=b[0])
                    return a[0]-b[0];
                return b[1]-a[1];
            }
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] last = stack.peek();
            int[] curr = intervals[i];
            if(last[1]>curr[0]) {
              int[] merged = new int[]{last[0], Integer.max(last[1], curr[1])};
                stack.pop();
                stack.push(merged);
            } else stack.push(curr);
        }

        Collections.reverse(stack);
        int[][] mergedIntervals = new int[stack.size()][2];
        int i=0;
        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            mergedIntervals[i++] = pair;
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
//        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] input = new int[][]{{1, 4}, {0, 4}};
        int[][] mergedIntervals = merge(input);
        for (int[] i : mergedIntervals) {
            System.out.print(String.format("[%d, %d], ", i[0], i[1]));
        }
    }
}
