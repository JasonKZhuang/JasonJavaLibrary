package com.jasonz.java8Features.functionalInterface;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 11:14
 * @project JasonJavaLibrary
 * @description:
 */
public interface IMyInterfaceCExtendsAB extends IMyInterfaceA,IMyInterfaceB {
    String singleAbstractMethodInC(int arg);

    @Override
    default String singleAbstractMethod(int arg) {
        return null;
    }

    @Override
    default void execute() {

        // When referring to an overridden method in a super-interface,
        // we must use the super keyword, prefixing it with the interface's name.
        // Such a prefix is necessary because it helps eliminate ambiguity if a type implements or extends multiple interfaces.
        IMyInterfaceB.super.execute();
    }
}
