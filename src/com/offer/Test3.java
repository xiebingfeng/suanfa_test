package com.offer;

public class Test3 {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

}