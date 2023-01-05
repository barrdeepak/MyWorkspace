package com.workspace.demo.leetcode.graphs;

import java.util.*;

/*
LC 323. Number of Connected Components in an Undirected Graph
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1

 */
public class NumberOfConnectedComponents {

    public static int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int counter = 0;
        Set<Integer> visited = new HashSet<>();

        for (Integer start : adjList.keySet()) {
            if (!visited.contains(start)) {
                bfs(adjList, start, visited);
                counter++;
            }
        }
        return counter;
    }

    public static void bfs(Map<Integer, List<Integer>> adjList, Integer start, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            visited.add(current);
            for (Integer neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 2}, {3, 4}};
//        int n = 5;
        int[][] edges = new int[][]{{1, 0}};
        int n = 2;
        int components = countComponents(n, edges);
        System.out.println("components = " + components);
    }
}
