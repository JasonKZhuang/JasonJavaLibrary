package com.jasonz.java8Features.lambda;

/**
 * @author Jason.Zhuang
 * Oct 22, 2019
 * FuncInterface.java
 * Describe: A sample functional interface
 * (An interface with single abstract method
 */
public interface FuncInterface {
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function 
    default void normalFun() {
        System.out.println("Hello");
    }
}
