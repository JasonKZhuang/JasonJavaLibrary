package com.jasonz.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) {
        MainTest mainTest = new MainTest();

        Product product = new Product();
        for (Field f : product.getClass().getDeclaredFields()) {
            System.out.println(f.getName());
        }
        for (Method method :  product.getClass().getDeclaredMethods()){
            System.out.println(method.getName());
        }
    }

}
