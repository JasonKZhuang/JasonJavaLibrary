package com.jasonz.java8Features.functionalInterface;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Jason Zhuang
 * @created 2024.03.20 18:27
 * @project JasonJavaLibrary
 * @description:
 */
public class UsePredicateFunction {
    public static void main(String[] args) {
        // Create a list of integers.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Define a predicate that tests if a number is even.
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Define a function that squares a number.
        Function<Integer, Integer> squareFunction = n -> n * n;

        // Apply the predicate to filter the list, and then apply the function to the filtered elements.
        List<Integer> evenSquares = numbers.stream()
                .filter(isEven)
                .map(squareFunction)
                .collect(Collectors.toList());

        // Print the result.
        System.out.println(evenSquares);
    }
}
