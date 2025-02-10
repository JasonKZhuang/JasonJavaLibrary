package com.jasonz.utilities;

import java.util.Arrays;

/**
 * @author : Jason Zhuang
 * @date : 5/3/2022
 * @description :
 */
public class Example {
    public static void main(String[] args) {

        System.out.println("Hello, world!");

        String[] array1 = {"apple", "banana", "cherry"};
        String[] array2 = {"apple", "banana", "cherry"};
        String[] array3 = array1;

        System.out.println(array1 == array2);
        System.out.println(array1 == array3);
        System.out.println(Arrays.equals(array1, array2));
        System.out.println(Arrays.hashCode(array1) == Arrays.hashCode(array2));

    }




}
