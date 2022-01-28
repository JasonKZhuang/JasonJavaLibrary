package com.jasonz.core;

/**
 * @author : Jason Zhuang
 * @date : 28/1/2022
 * @description :
 */
public class NumberHandler {
    public static void main(String[] args) {
        String str = NumberHandler.filterOutNonNumber("012.4jkf-1234#%^.,/;p'loZSW0354");
        System.out.println(str);
    }

    public static String filterOutNonNumber(String arg){
        String str = arg.replaceAll("[^\\d]", "");
        return str;
    }
}
