package com.leetcode.p100;

import com.bean.TreeNode;
import com.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的谦虚遍历
 */
public class Test144 {

    public List<Integer> preorderTraversal(TreeNode root) {
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
        res.add(root.val);

        if (null != root.left) {
            help(res, root.left);
        }

        if (null != root.right) {
            help(res, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree();
        TreeUtils.showTree(root);

        Test144 test = new Test144();
        List result = test.preorderTraversal(root);
        System.out.println(result);
    }

}
