package com.jasonz.java8Features.functionalInterface;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 09:39
 * @project JasonJavaLibrary
 * @description:
 */
public interface MyFunctionalInterface {
    public void singleAbstractMethod();

    // functional interface cannot have multiple abstract methods
    // since lambda expression can only be assigned to one abstract method
    // public void singleAbstractMethod2();
}
