package com.utils;


import com.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeUtils {

    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree() {
//        int[] preorder = new int[]{3, 9, 20, 15, 7, 6};
//        int[] inorder = new int[]{9, 3, 15, 20, 7, 6};
//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] inorder = new int[]{9, 3, 15, 20, 7};

        int[] preorder = new int[]{3, 9, 8, 1, 7, 6};
        int[] inorder = new int[]{9, 3, 1, 8, 7, 6};

        return buildTree(preorder, inorder);
    }

    public static TreeNode buildTree2() {
        int[] preorder = new int[]{20, 15};
        int[] inorder = new int[]{15, 20};

        return buildTree(preorder, inorder);
    }


    public static TreeNode buildTree3() {
        int[] preorder = new int[]{3, 9, 20};
        int[] inorder = new int[]{9, 3, 20};

        return buildTree(preorder, inorder);
    }

    public static TreeNode buildTree4() {
        int[] preorder = new int[]{3, 9, 20};
        int[] inorder = new int[]{9, 3, 20};

        return buildTree(preorder, inorder);
    }

    public static TreeNode buildTree5() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(9);
        return root;
    }

    public static void showTree(TreeNode root) {
        com.bean.TreeOperationUtils.show(root);
    }


    //    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]

    private static TreeNode myBuildTree(int[] preorder, int[] inorder,
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

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


}
