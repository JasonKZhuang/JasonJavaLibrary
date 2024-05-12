package com.jasonz.oop.abstraction;

/**
 * Accessibility of Data Members:
 * Members of a Java interface are public by default.
 *Lesson6Distinct Java abstract class can have class members like private, protected, etc.
 */
public abstract class AShape {
    String NAME_DEFAULT = "SHAPE";
    final String NAME_FINAL = "Final variable";
    static float area_static = 0.0f;
    int perimeter_default = 0;

    public AShape() {
        System.out.println("Shape is created in construction method");
    }

    public abstract void draw();

    public void changeColor() {
        System.out.println("Color changed");
    }
}
