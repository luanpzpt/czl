package com.library.utils;

public class StringIsEmpty {
    public static boolean isEmpty(String s){
        return s==null||"".equals(s.trim());
    }
}
