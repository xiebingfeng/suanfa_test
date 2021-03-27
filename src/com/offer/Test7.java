package com.offer;

import com.bean.TreeNode;
import com.bean.TreeOperationUtils;

import java.util.HashMap;
import java.util.Map;

public class Test7 {

//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]

    private TreeNode myBuildTree(int[] preorder, int[] inorder,
                                 int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        //2.找到中序遍历的那个点
        int inorderRootIndex = indexMap.get(preorder[preorderLeft]);

        //3.创建节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int size_left_tree = inorderRootIndex - inorderLeft;

        root.left = myBuildTree(preorder, inorder,
                preorderLeft + 1, preorderLeft + size_left_tree,
                inorderLeft, inorderRootIndex - 1);

        root.right = myBuildTree(preorder, inorder,
                preorderLeft + size_left_tree + 1, preorderRight,
                inorderRootIndex + 1, inorderRight);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7, 6};
        int[] inorder = new int[]{9, 3, 15, 20, 7, 6};

        Test7 test7 = new Test7();
        TreeNode root = test7.buildTree(preorder, inorder);

        TreeOperationUtils.show(root);
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

}
