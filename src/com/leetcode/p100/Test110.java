package com.leetcode.p100;

import com.bean.TreeNode;
import com.utils.TreeUtils;

/**
 * 自顶向下
 */
public class Test110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isBalanceLeft = isBalanced(root.left);
        boolean isBalanceRight = isBalanced(root.right);
        boolean isBalanceRoot = Math.abs(height(root.left) - height(root.right)) <= 1;

        return isBalanceLeft && isBalanceRight && isBalanceRoot;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        Test110 test110 = new Test110();

        TreeNode treeNode = TreeUtils.buildTree();
        TreeUtils.showTree(treeNode);

        boolean result = test110.isBalanced(treeNode);
        System.out.println(result);
    }

}
