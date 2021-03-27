package com.offer;


public class Test33 {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int rootValue = postorder[right];

        int leftTreeIndex = left;
        while (leftTreeIndex < right && postorder[leftTreeIndex] < rootValue) { // 从当前区域找到第一个大于根节点的，说明后续区域数值都在右子树中
            leftTreeIndex++;
        }

        for (int i = leftTreeIndex; i < right; i++) {
            if (postorder[i] < rootValue) {
                return false;
            }
        }

        if (!helper(postorder, left, leftTreeIndex - 1)) {
            return false;
        }

        if (!helper(postorder, leftTreeIndex, right - 1)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Test33 test33 = new Test33();
        int[] array = new int[]{4, 8, 6, 12, 16, 14, 10};
        boolean result = test33.verifyPostorder(array);
        System.out.println(result);
    }

}
