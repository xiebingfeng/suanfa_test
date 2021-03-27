package com.offer;

public class Test5 {

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");

    }

    public static void main(String[] args) {
        String result = new Test5().replaceSpace("We are happy.");
        System.out.println(result);
    }
}
