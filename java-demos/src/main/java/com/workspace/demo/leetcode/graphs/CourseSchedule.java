package com.workspace.demo.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            adjMap.put(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adjMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 1}};
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("result = " + result);
    }
}
