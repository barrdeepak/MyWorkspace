package com.workspace.demo.leetcode.graphs;


import java.util.*;

// 210. Course Schedule II
public class CourseSchedule2 {

//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] result = new int[numCourses];
//        int[] indegree = new int[numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            indegree[prerequisites[i][0]]++;
//        }
//        for (int j = 0; j < numCourses; j++) {
//            int i = 0;
//            while (i < indegree.length) {
//                if (indegree[i] == 0)
//                    break;
//                i++;
//            }
//            indegree[i] = -1;
//            result[j] = i;
//            for (int k = 0; k < prerequisites.length; k++) {
//                if (prerequisites[k][1] == i)
//                    indegree[prerequisites[k][0]]--;
//            }
//        }
//        return result;
//    }

    // Find order using topological sort recursive
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            adjMap.put(i, new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            adjMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (detectCycle(adjMap, i, visited, recStack)) {
                    System.out.println("Cycle detected");
                    return new int[1];
                }
            }
        }
        visited.clear();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i))
                topologicalSort(adjMap, i, visited, stack);
        }
        int[] result = new int[numCourses];
        int k = 0;
        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
        }
        return result;
    }

    public static boolean detectCycle(Map<Integer, List<Integer>> adjMap, int i, Set<Integer> visited, Set<Integer> recStack) {
        if(recStack.contains(i))
            return true;
        if(visited.contains(i))
            return false;
        visited.add(i);
        recStack.add(i);
        for (Integer n : adjMap.get(i)) {
            if (detectCycle(adjMap, n, visited, recStack))
                return true;
        }
        recStack.remove(i);
        return false;
    }


    public static void topologicalSort(Map<Integer, List<Integer>> adjMap, int i, Set<Integer> visited, Stack<Integer> order) {
        visited.add(i);
        for (int n : adjMap.get(i)) {
            if (!visited.contains(n))
                topologicalSort(adjMap, n, visited, order);
        }
        order.push(i);
    }

    public static void main(String[] args) {
        int numCourses = 4;
//        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        int[] order = findOrder(numCourses, prerequisites);

        for (int i : order)
            System.out.print(i + "\t");
        System.out.println();

    }
}
