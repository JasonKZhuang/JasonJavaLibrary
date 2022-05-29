package com.jasonz.oop.abstraction;

public interface IShape {

    //All the fields of an interface are public, static and, final by default.
    public static final String NAME_STATIC_FINAL = "SHAPE";

    public abstract void a();

    public void b();

    void c();

    static void dStatic() {
        System.out.println("this is static method in interface of Shape");
    }

    default void eDefault(String arg) {
        System.out.println("This is default method of interface of Shape " + arg);
    }
}
