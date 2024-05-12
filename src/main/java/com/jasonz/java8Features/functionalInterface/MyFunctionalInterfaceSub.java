package com.jasonz.java8Features.functionalInterface;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 09:43
 * @project JasonJavaLibrary
 * @description:
 */
public interface MyFunctionalInterfaceSub extends MyFunctionalInterface {

    public static void staticMethodWithImplementation1(String text, PrintWriter writer) throws IOException {
        System.out.println(text);
        writer.write(text);
    }

    public static void staticMethodWithImplementation2(String text, PrintWriter writer) throws IOException {
        System.out.println(text);
        writer.write(text);
    }

    public default void defaultMethodWithImplementation1(String text) {
        System.out.println("this is 1 of 2 default method in Functional Interface.");
    }

    public default void defaultMethodWithImplementation2(String text) {
        System.out.println("this is 2 of 2 default method in Functional Interface.");
    }
}
