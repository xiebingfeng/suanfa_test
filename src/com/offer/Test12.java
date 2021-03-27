package com.offer;

public class Test12 {

//    ["a","b","c","e"],
//    ["s","f","c","s"],
//    ["a","d","e","e"]]

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }

        char[] chs = word.toCharArray();

        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfs(board, i, j, isVisited, chs, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {
        if (chs.length == index) {
            return true;
        }

        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
            return false;
        }

        isVisited[i][j] = true;
        boolean res = dfs(board, i + 1, j, isVisited, chs, index + 1)
                || dfs(board, i - 1, j, isVisited, chs, index + 1)
                || dfs(board, i, j + 1, isVisited, chs, index + 1)
                || dfs(board, i, j - 1, isVisited, chs, index + 1);

        isVisited[i][j] = false;

        return res;
    }

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        char[][] board = new char[3][4];
        board[0] = new char[]{'a', 'b', 'c', 'e'};
        board[1] = new char[]{'s', 'f', 'c', 's'};
        board[2] = new char[]{'a', 'd', 'e', 'e'};
        boolean result = test12.exist(board, "asfced");
        System.out.println(result);
    }

}
