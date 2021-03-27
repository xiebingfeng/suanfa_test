package com.leetcode;

public class Test7 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //判断是否 大于 最大32位整数
            if (res > 214748364) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        int result = test7.reverse(12345678);
        System.out.println(result);
    }
}
