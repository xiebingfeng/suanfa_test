package com.offer;

import com.bean.ListNode;
import com.utils.DataUtils;
import com.utils.DataUtilsKt;

public class Test21 {

    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {

            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }

            while (left < right && (nums[right] & 1) != 1) {
                right--;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Test21 test21 = new Test21();
        int[] result = test21.exchange(new int[]{1, 2, 3, 4, 5});
        DataUtils.printArray(result);
    }

}
