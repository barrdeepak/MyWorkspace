package com.workspace.demo.leetcode.linkedlist.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LLUtil {

    public static ListNode createLL() {
        ListNode head = new ListNode(1, null);
        ListNode n1 = new ListNode(2, head);
        ListNode n2 = new ListNode(3, n1);
        ListNode n3 = new ListNode(4, n2);
        ListNode n4 = new ListNode(5, n3);
        head = n4;
        return head;
    }

    public static ListNode createLL(int[] values) {
        ListNode head = null;
        for (int v : values) {
            if (head == null)
                head = new ListNode(v, null);
            else {
                ListNode n = new ListNode(v, head);
                head = n;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("");
    }
}
