package com.leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 回溯
 */
public class Test17 {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {
        if (digits.length() == index) {
            combinations.add(stringBuffer.toString());
            return;
        }

        String curString = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < curString.length(); i++) {
            stringBuffer.append(curString.charAt(i));
            backtrack(combinations, phoneMap, digits, index + 1, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    public static void main(String[] args) {
        Test17 test17 = new Test17();
        System.out.println(test17.letterCombinations("23"));
    }


//         if (digits.length() == index) {
//        combinations.add(stringBuffer.toString());
//        return;
//    }

//    String curString = phoneMap.get(digits.charAt(index));

//        for (int i = 0; i < curString.length(); i++) {
//        stringBuffer.append(curString.charAt(i));
//        backtrack(combinations, phoneMap, digits, index + 1, stringBuffer);
//        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
//    }

}
