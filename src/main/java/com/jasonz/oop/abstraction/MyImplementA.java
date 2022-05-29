package com.jasonz.oop.abstraction;

public class MyImplementA implements IShape {

    @Override
    public void a() {
        System.out.println("call the interface variable:"+IShape.NAME_STATIC_FINAL);
    }

    @Override
    public void b() {
        System.out.println("call the MyImplementA static variable:"+ MyImplementA.NAME_STATIC_FINAL);
    }

    @Override
    public void c() {
        System.out.println("This is c method in implement.");
    }
}
