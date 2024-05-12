package com.jasonz.oop.basic;

/**
 * @author Jason Zhuang
 * @created 2024.03.20 13:57
 * @project JasonJavaLibrary
 * @description:
 */
public class ClassInitializeWithStatic {

    // this static variable only run once when class is first loaded before any instance was declared and created
    public static int capacity = 10;

    // this variable will run when every instance is declared and created
    private boolean myPrivateBooleanVariable = false;

    /**
     * If initialization requires some logic
     * (for example, error handling or a for loop to fill a complex array),
     * simple assignment is inadequate.
     * Instance variables can be initialized in constructors,
     * where error handling or other logic can be used.
     * To provide the same capability for class variables,
     * the Java programming language includes static initialization blocks.
     */
    // this static method only run once when class is first loaded before any instance was declared and created.
    // this static method will run after all static variables were loaded.
    static {
        // whatever code is needed for initialization goes here
        System.out.println("this is 1st static method.");
    }

    public void myMethod1(){
        System.out.println("this is my method with static value : " + capacity);
        myPrivateBooleanVariable = true;
    }

    // this static method only run once when class is first loaded before any instance was declared and created.
    // this static method will run after all static variables were loaded as sequence of code.
    static {
        // whatever code is needed for initialization goes here
        System.out.println("this is 2nd static method.");
    }

    public static void main(String[] args) {
        ClassInitializeWithStatic first =  null;
        ClassInitializeWithStatic ins = new ClassInitializeWithStatic();
        ins.myMethod1();
        ClassInitializeWithStatic ins2 = new ClassInitializeWithStatic();
        ins2.myMethod1();
    }
}
