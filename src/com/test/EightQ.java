package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EightQ {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> colPos = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        DFS(0, colPos, col, pie, na, n);

        List<List<String>> print = printQueens(colPos, n);
        return print;
    }

    public void DFS(int row, List<List<Integer>> colPos, List<Integer> col,
                    Set<Integer> pie, Set<Integer> na, int n) {
        if (row >= n) {
            List<Integer> res = new ArrayList<Integer>(); //深拷贝，因为col是动态变化的，所以结果要先保存起来
            res.addAll(col);
            colPos.add(res);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i) || pie.contains(row + i) || na.contains(row - i)) {
                continue;
            }

            col.add(i);
            pie.add(row + i);
            na.add(row - i);
            DFS(row + 1, colPos, col, pie, na, n);

            col.remove(col.indexOf(i));
            pie.remove(row + i);
            na.remove(row - i);
        }
    }

    public List<List<String>> printQueens(List<List<Integer>> colPos, int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int num = 0; num < colPos.size(); num++) {
            List<String> oneRes = new ArrayList<String>();
            for (int i = 0; i < colPos.get(num).size(); i++) {
                StringBuilder sb = new StringBuilder(); //打印输出
                int j = colPos.get(num).get(i);
                for (int x = 0; x < j; x++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int x = j + 1; x < n; x++) {
                    sb.append(".");
                }
                String str = sb.toString();
                oneRes.add(str);
            }
            result.add(oneRes);
        }
        return result;
    }

    public static void main(String[] args) {
        EightQ eightQ = new EightQ();
        List<List<String>> result = eightQ.solveNQueens(4);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}