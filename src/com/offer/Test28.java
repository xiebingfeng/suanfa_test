package com.offer;

import com.bean.TreeNode;
import com.utils.TreeUtils;

public class Test28 {

//                    1
//                  /    \
//                 2      2
//                / \    / \
//               3   4  4   3

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isHelper(root.left, root.right);
    }

    private boolean isHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && isHelper(left.left, right.right) && isHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        Test28 test28 = new Test28();

        TreeNode treeNode = TreeUtils.buildTree5();
        TreeUtils.showTree(treeNode);
        boolean result = test28.isSymmetric(treeNode);
        System.out.println(result);
    }
}
