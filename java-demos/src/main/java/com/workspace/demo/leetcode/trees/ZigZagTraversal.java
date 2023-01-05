package com.workspace.demo.leetcode.trees;

import java.util.*;

public class ZigZagTraversal {

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> currList = new ArrayList<>();
        int counter = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                if (++counter % 2 == 0)
                    Collections.reverse(currList);
                output.add(currList);
                currList = new ArrayList<>();
                queue.add(null);
            } else {
                currList.add(t.val);
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
        }
        return output;
    }
}
