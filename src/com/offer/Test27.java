package com.offer;

import com.bean.TreeNode;
import com.utils.DataUtils;
import com.utils.TreeUtils;

public class Test27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);

        return root;
    }

    public static void main(String[] args) {
        Test27 test27 = new Test27();

        TreeNode treeNode = TreeUtils.buildTree3();
        TreeUtils.showTree(treeNode);
        TreeNode result = test27.mirrorTree(treeNode);
        TreeUtils.showTree(result);

    }
}
