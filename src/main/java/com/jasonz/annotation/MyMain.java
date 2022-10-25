package com.jasonz.annotation;


import com.jasonz.annotation.custom.BasicEngineClassLevel;

import java.lang.annotation.Annotation;

public class MyMain {
    public static void main(String[] args) {
        MyMain myMain = new MyMain();
        myMain.testClassLevelAnnotation();

    }
    private void testClassLevelAnnotation(){
        Car car = new Car("Toyota", "Camry");
        car.getCarDetails();
        Class carClass = car.getClass();

        Annotation testAnn = carClass.getAnnotation(BasicEngineClassLevel.class);
        BasicEngineClassLevel engine = (BasicEngineClassLevel)testAnn;
        System.out.println("BasicEngine Mileage: " + engine.mileage());
        System.out.println("BasicEngine FuelType: " + engine.fuelType());
    }
}
