package com.leetcode.p100;

public class Test153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            if (r - l <= 1) {
                if (nums[r] > nums[l]) {
                    return nums[l];
                } else {
                    return nums[r];
                }
            }
            int mid = l + (r - l) / 2;
            if (nums[r] > nums[mid]) {
                r = mid;
            } else if (nums[mid] > nums[l]) {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Test153 test153 = new Test153();
        int result = test153.findMin(new int[]{5, 6, 7, 8, 9, 1, 2});
        System.out.println(result);
    }

}
