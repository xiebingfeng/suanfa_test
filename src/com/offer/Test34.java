package com.offer;


import com.bean.TreeNode;
import com.utils.TreeUtils;

import java.util.LinkedList;
import java.util.List;

public class Test34 {

    LinkedList<Integer>       path = new LinkedList<>();
    LinkedList<List<Integer>> res  = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        sum -= root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }

        recur(root.left, sum);
        recur(root.right, sum);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode rootNode = TreeUtils.buildTree();
        TreeUtils.showTree(rootNode);

        Test34 test34 = new Test34();
        List<List<Integer>> result = test34.pathSum(rootNode, 12);
        System.out.println(result);
    }

}
