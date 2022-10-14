package com.jasonz.annotation;

import com.jasonz.annotation.custom.BasicEngineClassLevel;

@BasicEngineClassLevel(mileage = "80",fuelType = "Diesel")
public class Car {
    String make;
    String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void getCarDetails() {
        System.out.println("Car Manufacturer: " + make);
        System.out.println("Car Model: " + model);
    }
}