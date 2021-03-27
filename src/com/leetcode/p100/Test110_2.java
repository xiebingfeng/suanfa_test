package com.leetcode.p100;

import com.bean.TreeNode;
import com.heap.MaxHeap;
import com.utils.TreeUtils;

/**
 * 自底向上
 */
public class Test110_2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) > 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public static void main(String[] args) {
        Test110_2 test110 = new Test110_2();

        TreeNode treeNode = TreeUtils.buildTree();
        TreeUtils.showTree(treeNode);

        boolean result = test110.isBalanced(treeNode);
        System.out.println(result);
    }

}
