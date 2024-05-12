package com.jasonz.dataStructures.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 20:21
 * @project JasonJavaLibrary
 * @description:
 */
public class Samples {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list instanceof List);
        System.out.println(list instanceof List<?>);
        System.out.println(list instanceof List<Integer>);
        System.out.println(list instanceof ArrayList);
        System.out.println(list instanceof ArrayList<?>);
        System.out.println(list instanceof ArrayList<Integer>);
    }
}
