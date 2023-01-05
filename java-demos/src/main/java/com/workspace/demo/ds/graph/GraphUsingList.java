package com.workspace.demo.ds.graph;


import java.util.*;

/**
 * Created by deepak on 11/25/14.
 */

public class GraphUsingList {

    private Map<Vertex, List<Vertex>> adjList;
    int size;

    public GraphUsingList() {
        adjList = new HashMap<>();
        size = 0;
    }

    public void addVertex(char c) {
        adjList.put(new Vertex(c), new ArrayList<>());
    }

    public void addEdge(char a, char b) {
        List<Vertex> list = adjList.get(new Vertex(a));
        Vertex v = searchVertex(b);
        list.add(v);
    }

    private Vertex searchVertex(char b) {
        Vertex toSearch = new Vertex(b);
        for (Vertex v : adjList.keySet())
            if (v.equals(toSearch))
                return v;
        throw new RuntimeException("Vertex does not exist");
    }

    public void printVertices() {
        for (Vertex v : adjList.keySet())
            System.out.print(v.getLabel() + "\t");
        System.out.println();
    }

    // Passing visited because It useful to get number of connected components
    public void bfs(char c, Set<Vertex> visited) {
        System.out.println("Breath first search starting with " + c);
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = searchVertex(c);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v.getLabel() + "\t");
            visited.add(v);
            for (Vertex n : adjList.get(v)) {
                if (!visited.contains(n))
                    queue.add(n);
            }
        }
        System.out.println("");
    }

    public void dfs(char c, Set<Vertex> visited) {
        System.out.println("Depth first search starting with " + c);
        Vertex start = searchVertex(c);
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            System.out.print(v.getLabel() + "\t");
            visited.add(v);
            for (Vertex n : adjList.get(v)) {
                if (!visited.contains(n))
                    stack.push(n);
            }
        }
        System.out.println("");
    }

    public void topologicalSort(char c, Set<Vertex> visited) {
        System.out.println("Depth first search starting with " + c);
        Vertex start = searchVertex(c);
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            System.out.print(v.getLabel() + "\t");
            visited.add(v);
            for (Vertex n : adjList.get(v)) {
                if (!visited.contains(n))
                    stack.push(n);
            }
        }
        System.out.println("");
    }

    public int getNumberOfConnectedComponents() {
        Set<Vertex> visited = new HashSet<>();
        int counter = 0;
        for (Vertex v : adjList.keySet()) {
            if (!visited.contains(v)) {
                bfs(v.label, visited);
                counter++;
            }
        }
        return counter;
    }

    public boolean cycleDetected(char c) {
        Set<Vertex> beingVisited = new HashSet<>();
        Set<Vertex> visited = new HashSet<>();
        return cycleDetectedRecursive(c, visited, beingVisited);
    }


    public boolean cycleDetectedRecursive(char c, Set<Vertex> visited, Set<Vertex> beingVisited) {
        Vertex start = searchVertex(c);
        beingVisited.add(start);
        for (Vertex neighbour : adjList.get(start)) {
            if (beingVisited.contains(neighbour))
                return true;
            else if (!visited.contains(neighbour)) {
                if (cycleDetectedRecursive(neighbour.label, visited, beingVisited))
                    return true;
            }
        }
        beingVisited.remove(start);
        visited.add(start);
        return false;
    }

    public static void main(String[] args) {
        GraphUsingList graph = new GraphUsingList();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addEdge('a', 'b');
        graph.addEdge('a', 'c');
        graph.addEdge('b', 'e');
        graph.addEdge('c', 'd');
        graph.addEdge('e', 'd');
        graph.addEdge('d', 'b');

        graph.printVertices();
        Set<Vertex> visited = new HashSet<>();
        graph.bfs('a', visited);
        graph.dfs('a', new HashSet<>());

        int connectedComponents = graph.getNumberOfConnectedComponents();
        System.out.println("connectedComponents = " + connectedComponents);
        boolean isCyclic = graph.cycleDetected('a');
        System.out.println("isCyclic = " + isCyclic);


    }
}
