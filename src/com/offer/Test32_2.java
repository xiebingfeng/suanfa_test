package com.offer;

import com.bean.TreeNode;
import com.utils.DataUtils;
import com.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {

            ArrayList<Integer> rowList = new ArrayList<>();
            int size = deque.size() - 1;
            while (!deque.isEmpty() && size >= 0) {
                TreeNode currentNode = deque.poll();
                rowList.add(currentNode.val);
                size--;

                if (currentNode.left != null) {
                    deque.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    deque.add(currentNode.right);
                }
            }
            resultList.add(rowList);

        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree();

        Test32_2 test33 = new Test32_2();
        List<List<Integer>> result = test33.levelOrder(root);
        DataUtils.printList(result);

        TreeUtils.showTree(root);
    }

}
