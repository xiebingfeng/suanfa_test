package com.offer;

public class Test15 {

    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;

            if (n == 0) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        int result = test15.hammingWeight(3);
        System.out.println(result);
    }


//    int count = 0;
//        for (int i = 0; i < 32; i++) {
//        if ((n & 1) != 0) {
//            count++;
//        }
//        n = n >> 1;
//    }
//        return count;

}
