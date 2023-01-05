package com.workspace.demo.leetcode.graphs;

// LC 200. Number of Islands
// Seems like number of connected components in a graph problem

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Index {
    int i, j;

    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    counter++;
                }
            }
        }
        return counter;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] n : getNeighbours(i, j, grid))
            if(!visited[n[0]][n[1]])
                dfs(n[0],n[1], grid, visited);
    }

//
//    public void bfs(int i, int j, char[][] grid, boolean[][] visited) {
//        Queue<Index> queue = new LinkedList<>();
//        queue.add(new Index(i, j));
//
//        while (!queue.isEmpty()) {
//            Index idx = queue.poll();
//            visited[idx.i][idx.j] = true;
//            for (int[] neighbour : getNeighbours(idx, grid))
//                if (!visited[neighbour[0]][neighbour[1]])
//                    queue.add(neighbour);
//        }
//    }

    public List<int[]> getNeighbours(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> neighbours = new ArrayList<>();
        if (i + 1 < m && grid[i + 1][j] == '1')
            neighbours.add(new int[]{i + 1, j});
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            neighbours.add(new int[]{i - 1, j});
        if (j + 1 < n && grid[i][j + 1] == '1')
            neighbours.add(new int[]{i, j + 1});
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            neighbours.add(new int[]{i, j - 1});
        return neighbours;
    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
//        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        int islands = new NumberOfIslands().numIslands(grid);
        System.out.println("islands = " + islands);
    }
}
