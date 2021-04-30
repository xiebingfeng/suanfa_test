package com.leetcode.p200;

import com.utils.DataUtils;

public class Test283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int isZeroPosition = 0;
        int length = nums.length;

        while (i < length) {
            if (nums[i] != 0) {
                if (isZeroPosition < i) {
                    nums[isZeroPosition] = nums[i];
                }
                isZeroPosition++;
            }
            i++;
        }

        for (int j = isZeroPosition; j < length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        Test283 test = new Test283();

        int[] array = new int[]{1, 0, 0, 0, 3, 9};
        test.moveZeroes(array);
        DataUtils.printArray(array);
    }

}
