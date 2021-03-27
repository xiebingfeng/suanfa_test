package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    //()()    (())

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if (n < 1) {
            return resultList;
        }
        dfs(resultList, "", n);

        return resultList;
    }

    private void dfs(List<String> resultList, String path, int n) {
        System.out.println(resultList);
        if (path.length() == 2 * n) {
            resultList.add(path);
            return;
        }


        dfs(resultList, path + "(", n);
        dfs(resultList, path + ")", n);
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        List<String> result = test22.generateParenthesis(2);
        System.out.println(result);
    }

}
