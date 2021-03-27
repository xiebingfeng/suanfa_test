package com.leetcode;

public class Test11 {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int i = 0, j = height.length - 1;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);

            maxArea = Math.max(maxArea, curArea);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        int result = test11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result);
    }

}
