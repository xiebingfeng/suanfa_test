package com.offer;

import com.bean.ListNode;
import com.bean.TreeNode;
import com.utils.DataUtils;
import com.utils.TreeUtils;

import javax.xml.crypto.Data;

public class Test26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();

        TreeNode treeNode1 = TreeUtils.buildTree();
        TreeNode treeNode2 = TreeUtils.buildTree2();

        TreeUtils.showTree(treeNode1);
        TreeUtils.showTree(treeNode2);

        boolean result = test26.isSubStructure(treeNode1, treeNode2);
        System.out.println(result);

//        ListNode result = test26.isSubStructure(treeNode1, treeNode2);
//        DataUtils.printListNode(result);
    }

}
