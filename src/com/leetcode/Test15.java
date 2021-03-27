package com.leetcode;

import com.utils.DataUtils;
import com.utils.DataUtilsKt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return listAll;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    listAll.add(list);

                    while (l + 1 < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (r - 1 >= 0 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                }

                if (sum > 0) r--;
                else l++;
            }
        }
        return listAll;
    }

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        List<List<Integer>> resultLists = test15.threeSum(new int[]{-1, 0, 1, 1});
//        List<List<Integer>> resultLists = test15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(resultLists);
    }

}
