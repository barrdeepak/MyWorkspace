package com.workspace.demo.leetcode.stack;


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        if (!q1.isEmpty())
            q1.add(x);
        else q2.add(x);
    }

    public int pop() {
        if (empty())
            throw new RuntimeException("No elements are present");
        if (q1.isEmpty()) {
            while (q2.size() > 1)
                q1.add(q2.poll());
            return q2.poll();
        } else {
            while (q1.size() > 1)
                q2.add(q1.poll());
            return q1.poll();
        }
    }

    public int top() {
        if (empty())
            throw new RuntimeException("No elements are present");

        if (q1.isEmpty()) {
            while (q2.size() > 1)
                q1.add(q2.poll());
            int topValue = q2.poll();
            q1.add(topValue);
            return topValue;
        } else {
            while (q1.size() > 1)
                q2.add(q1.poll());
            int topValue = q1.poll();
            q2.add(topValue);
            return topValue;
        }
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {

    }
}
