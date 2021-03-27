package com.offer;

public class Test4 {

//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],


//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int i = matrix[0].length - 1;
        int j = 0;

        while (i >= 0 && j < matrix.length) {
            int currentNum = matrix[j][i];
            if (currentNum > target) {
                i--;
            } else if (currentNum < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[3][5];
        array[0][0] = 1;
        array[0][1] = 4;
        array[0][2] = 7;
        array[0][3] = 11;
        array[0][4] = 15;

        array[1][0] = 2;
        array[1][1] = 5;
        array[1][2] = 8;
        array[1][3] = 12;
        array[1][4] = 19;

        array[2][0] = 3;
        array[2][1] = 6;
        array[2][2] = 9;
        array[2][3] = 16;
        array[2][4] = 22;

//        array[3][0] = 10;
//        array[3][1] = 13;
//        array[3][2] = 14;
//        array[3][3] = 17;
//        array[3][4] = 24;

        boolean result = new Test4().findNumberIn2DArray(array, 23);
//        boolean result = new Test4().findNumberIn2DArray(array, 15);
        System.out.println(result);
    }
}
