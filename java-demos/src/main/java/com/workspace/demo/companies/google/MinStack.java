package com.workspace.demo.companies.google;

import java.util.Stack;

public class MinStack {
  Stack<Integer> stack = new Stack();
  Stack<Integer> minStack = new Stack();

  public void push(Integer i) {
    stack.push(i);
    if (minStack.isEmpty() || i <= minStack.peek()) {
      minStack.push(i);
    }
  }

  public Integer pop(){
    if(stack.isEmpty())
      throw new RuntimeException("Stack is empty");
    int out = stack.pop();
    if(out == minStack.peek())
      minStack.pop();
    return out;
  }

  public Integer min(){
    if(minStack.isEmpty())
      throw new RuntimeException("Stack is empty");
    return minStack.peek();
  }

  public Integer peek(){
    if(stack.isEmpty())
      throw new RuntimeException("Stack is empty");
    return stack.peek();
  }
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(4);
    minStack.push(5);
    minStack.push(1);
    minStack.push(3);

    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.min());
    minStack.pop();
    minStack.push(2);
    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.min());
  }
}
