package com.jasonz.oop.basic;

/**
 * @author Jason Zhuang
 * @created 2024.03.20 18:39
 * @project JasonJavaLibrary
 * @description:
 */
public class BasicTest {
    public static void main(String[] args) {
        ClassInitializeWithStatic s1 = null;
        s1 = new ClassInitializeWithStatic();
        s1.myMethod1();
        s1 = new ClassInitializeWithStatic();
        s1.myMethod1();

    }
}
