package com.leetcode;

import com.bean.TreeNode;
import com.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的谦虚遍历
 */
public class Test94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        help(res, root);
        return res;
    }

    private void help(List<Integer> res, TreeNode root) {
        if (null == root) {
            return;
        }

        if (null != root.left) {
            help(res, root.left);
        }

        res.add(root.val);

        if (null != root.right) {
            help(res, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree();
        TreeUtils.showTree(root);

        Test94 test = new Test94();
        List result = test.inorderTraversal(root);
        System.out.println(result);
    }

}
