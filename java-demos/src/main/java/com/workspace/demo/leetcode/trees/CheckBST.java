package com.workspace.demo.leetcode.trees;


// LC 98. Validate Binary Search Tree
public class CheckBST {


    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.val >= root.val)
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {

    }
}
