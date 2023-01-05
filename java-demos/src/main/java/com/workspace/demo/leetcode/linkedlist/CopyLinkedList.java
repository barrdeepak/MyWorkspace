package com.workspace.demo.leetcode.linkedlist;

/*
LC 138. Copy List with Random Pointer
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLinkedList {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;

        Node curr = head;
        while (curr != null) {
            Node n = new Node(curr.val);
            n.next = curr.next;
            curr.next = n;
            curr = n.next;
        }

        Node newHead = head.next;
        curr = head;
        while (curr != null) {
            Node t = curr.next;
            if (curr.random != null)
                t.random = curr.random.next;
            curr = t.next;
        }

        curr = head;
        while (curr != null) {
            Node t = curr.next;
            curr.next = t.next;
            curr = t.next;
            if (curr != null)
                t.next = curr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
    }
}
