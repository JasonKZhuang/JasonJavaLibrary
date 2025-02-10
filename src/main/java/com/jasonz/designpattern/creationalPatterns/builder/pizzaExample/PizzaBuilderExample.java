package com.jasonz.designpattern.creationalPatterns.builder.pizzaExample;

/**
 * @author Jason Zhuang
 * @created 2024.05.30 15:01
 * @project JasonJavaLibrary
 * @description:
 *
 * The Builder Pattern is a creational design pattern that allows the construction of complex objects step by step.
 * It separates the construction of a complex object from its representation,
 * so that the same construction process can create different representations.
 * This pattern is particularly useful when dealing with classes
 * that have a large number of optional parameters or configurations.
 */
public class PizzaBuilderExample {

    public static void main(String[] args) {

        // Creating a pizza with only required parameters
        Pizza pizza1 = new Pizza.Builder("Thin crust", "Tomato sauce")
                .build();
        System.out.println("Pizza 1: " + pizza1);

        // Creating a pizza with all parameters
        Pizza pizza2 = new Pizza.Builder("Thick crust", "BBQ sauce")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(true)
                .build();
        System.out.println("Pizza 2: " + pizza2);

    }

}
