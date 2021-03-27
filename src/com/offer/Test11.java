package com.offer;

public class Test11 {

    public int minArray(int[] numbers) {

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            //最右边的比中间的大，那么最小值肯定在l---mid之间
            if (numbers[r] > numbers[mid]) {
                r = mid;
            }
            //中间的比最右边的大,那么最小值肯定在  mid+1  ----r之间。
            else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        int result = test11.minArray(new int[]{5, 6, 1, 2, 3, 4,});
        System.out.println(result);
    }

}
