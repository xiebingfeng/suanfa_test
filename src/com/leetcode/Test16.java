package com.leetcode;

import java.util.Arrays;

public class Test16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - min)) {
                    min = sum;
                }

                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return min;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Test16 test16 = new Test16();
        System.out.println(test16.threeSumClosest(new int[]{1, 1, 1, 0}, 100));
//        System.out.println(test16.threeSumClosest(new int[]{0, 2, 1, -3}, 0));
    }
}
