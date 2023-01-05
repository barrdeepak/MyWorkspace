package com.workspace.demo.leetcode.linkedlist;

// 234. Palindrome Linked List

import com.workspace.demo.leetcode.linkedlist.util.LLUtil;
import com.workspace.demo.leetcode.linkedlist.util.ListNode;

import java.util.Stack;

public class isPalindrome {

    public static boolean checkPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode slow = head, fast = head;
        stack.push(slow);
        int counter = 0;
        while (fast != null) {
            fast = fast.next;
            if (++counter % 2 == 0) {
                slow = slow.next;
                stack.push(slow);
            }
        }
           if(counter%2==0)
               stack.pop();

        while(slow !=null)
        {
            ListNode pop = stack.pop();
            if(pop.val!=slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = LLUtil.createLL();
        boolean result = checkPalindrome(head);
        System.out.println("resul1Rt = " + result);
    }
}
