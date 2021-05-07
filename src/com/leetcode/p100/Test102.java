package com.leetcode.p100;

import com.bean.TreeNode;
import com.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的谦虚遍历
 */
public class Test102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque deque = new LinkedList();
        if (null == root) {
            return res;
        }
        deque.addLast(deque);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree();
        TreeUtils.showTree(root);

        Test102 test = new Test102();
        List result = test.levelOrder(root);
        System.out.println(result);
    }

}
