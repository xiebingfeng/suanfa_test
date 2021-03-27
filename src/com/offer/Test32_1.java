package com.offer;

import com.bean.TreeNode;
import com.utils.DataUtils;
import com.utils.TreeUtils;

import java.util.*;

public class Test32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.poll();
            arrayList.add(treeNode.val);

            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }

            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }

        }

        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree();

        Test32_1 test32 = new Test32_1();
        int[] result = test32.levelOrder(root);
        DataUtils.printArray(result);

        TreeUtils.showTree(root);
    }

}
