package com.jasonz.java8Features.functionalInterface;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 09:41
 * @project JasonJavaLibrary
 * @description:
 */
public class MyImplementationClass implements MyFunctionalInterfaceSub {

    @Override
    public void singleAbstractMethod() {
        System.out.println("this Functional Interface only contain single abstract method.");
    }

    @Override
    public void defaultMethodWithImplementation1(String text) {
        MyFunctionalInterfaceSub.super.defaultMethodWithImplementation1(text);
    }

    @Override
    public void defaultMethodWithImplementation2(String text) {
        MyFunctionalInterfaceSub.super.defaultMethodWithImplementation2(text);
    }
}
