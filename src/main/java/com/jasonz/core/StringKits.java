package com.jasonz.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Jason Zhuang
 * @date : 31/1/2022
 * @description :
 */
public class StringKits {
    public static void main(String[] args) {
        String v = "06104123";
        List<String> lst = new ArrayList<>();
        lst.add("6104");
        lst.add("04");
        lst.add("4");
        System.out.println(StringKits.usingStartsWith(v,lst));
    }

    public static String usingStartsWith(String arg, List<String> prefix) {
        for (String v : prefix) {
            if (arg.startsWith(v)){
                return arg;
            }
        }
        return "";
    }

    public static String usingStartsWith2(String arg, List<String> prefix) {
        String retValue = "";
        Stream<String> a = prefix.stream().filter(
                (value) -> {
                    if (arg.startsWith(value)) {
                        return true;
                    }
                    return false;
                });
        return a.toString();
    }
}
