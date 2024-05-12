package com.jasonz.java8Features.functionalInterface;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 11:14
 * @project JasonJavaLibrary
 * @description:
 */
public interface IMyInterfaceB {
    String singleAbstractMethod(int arg);
    //    default String singleAbstractMethod(int arg){
    //        System.out.println(arg);
    //        return "ok";
    //    }

    default void execute() {
        System.out.println("this is default method in IMyInterfaceB");
    }
}
