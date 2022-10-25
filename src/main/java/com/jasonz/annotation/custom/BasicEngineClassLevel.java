package com.jasonz.annotation.custom;

import java.lang.annotation.*;
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BasicEngineClassLevel {
    String mileage() default "20";
    String fuelType() default "Gasoline";
}