package com.jasonz.oop.abstraction;

public class ShapeRectangle extends AShape {

    @Override
    public void draw() {
        System.out.println("The default value in abstract shape: "+this.NAME_DEFAULT);
        System.out.println("The FINAL value in abstract shape: " + this.NAME_FINAL);
        System.out.println("The STATIC value in abstract shape: " + AShape.area_static);
        System.out.println("The implement method in child class - drawing rectangle");
    }

}
