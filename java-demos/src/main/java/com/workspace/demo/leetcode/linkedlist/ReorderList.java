package com.workspace.demo.leetcode.linkedlist;

import com.workspace.demo.leetcode.linkedlist.util.LLUtil;
import com.workspace.demo.leetcode.linkedlist.util.ListNode;

import java.util.Stack;

public class ReorderList {

    private static void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        int counter = 0;
        while (fast != null) {
            fast = fast.next;
            if (++counter % 2 == 0)
                slow = slow.next;
        }

        Stack<ListNode> stack = new Stack();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode curr = head;
        while (curr != null) {
            if(stack.isEmpty()) {
                curr.next = null;
                break;
            }
            ListNode pop = stack.pop();
            if (curr == pop) {
                curr.next = null;
                break;
            }
            ListNode t = curr.next;
            curr.next = pop;
            pop.next = t;
            curr = t;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1};
        ListNode head = LLUtil.createLL(input);
        LLUtil.printList(head);
        reorderList(head);
        System.out.println("After reordering...");
        LLUtil.printList(head);
    }
}
