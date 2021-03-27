package com.leetcode;

import javax.swing.text.html.HTML;
import java.util.HashMap;

public class Test1 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int length = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int temp;
        for (int i = 0; i < length; i++) {
            temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{i, hashMap.get(temp)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        Test1 test1 = new Test1();
        int[] result = test1.twoSum(nums, 7);
        if (result != null) {
            System.out.println(result[0] + "   " + result[1]);
        } else {
            System.out.println("wrong");
        }
    }
}
