package com.jasonz.oop.abstraction;

public class MainTest {
    public static void main(String[] args) {
        IShape obj = new MyImplementA();
        obj.a();
        obj.b();
        obj.c();
        obj.eDefault("something");
        IShape.dStatic();
        System.out.println("----------------------------");
        AShape shape = new ShapeRectangle();
        shape.draw();
    }
}
