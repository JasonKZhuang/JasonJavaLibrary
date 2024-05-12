package com.jasonz.java8Features.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * What is Lambda Expression? syntax is (argument) -> (body) For exmaple:
 * Runnable r1 = () -> System.out.println("My Runnable");
 * <p>
 * Why do we need Lambda Expression?
 * 1.Reduced Lines of Code
 * 2.Sequential and Parallel Execution Support
 * 3.Passing Behaviors into methods
 * 4.Higher Efficiency with Laziness
 *
 * @author Jason Zhuang 23 Jun. 2021
 */
public class LambdaExpressionSamples {

    public static void main(String[] args) {
        int test = 7;
        System.out.println(isPrimeTraditional(test));
        System.out.println(isPrimeDeclarative1(test));
        System.out.println(isPrimeDeclarative2(test));

        List numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        //sum of all numbers
        //passing lambda condition as an argument to the function
        int v1 = sumWithCondition(numbers, n -> true);
        System.out.println(v1);

        //sum of all even numbers
        int v2 = sumWithCondition(numbers, i -> i % 2 == 0);
        System.out.println(v2);

        //sum of all numbers greater than 5
        int v3 = sumWithCondition(numbers, i -> i > 5);
        System.out.println(v3);

    }

    // Traditional approach
    // The problem with below code is that
    // it’s sequential in nature, if the number is very huge then it will take
    // significant amount of time.
    // Another problem with code is that there are so many exit points and it’s not
    // readable.
    // Let’s see how we can write the same method using lambda expressions and
    // stream API.
    private static boolean isPrimeTraditional(int number) {
        if (number < 2)
            return false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }

    // Declarative approach
    private static boolean isPrimeDeclarative1(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    // Declarative approach
    // Sequential and Parallel Execution Support
    private static boolean isPrimeDeclarative2(int number) {
        IntPredicate isDivisible = (index) -> {
            return number % index == 0;
        };

        return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
    }


    /**
     * Passing Behaviors into methods
     *
     * @param numbers   a List of Integer
     * @param predicate the condition lambda expression which returns a boolean type
     * @return
     */
    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream() // execute stream line
                .filter(predicate) // filter list with predicate is true, narrow the range of the list
                .mapToInt(i -> i) // do some calculation or other business logic for each element of the List
                .sum(); //execute sum method which is in the IntStream Interface
    }

    /**
     * traditional way:
     * find out the maximum odd number in the range 3 to 11 and return square of it.
     *
     * @param numbers the list of a number
     * @return
     */
    private static int findSquareOfMaxOddTraditional(List<Integer> numbers) {
        int max = 0;
        for (int i : numbers) {
            if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
                max = i;
            }
        }
        return max * max;
    }

    // use Stream API to achieve this and get benefit of Laziness-seeking.
    // the double colon (::) operator, it’s introduced in Java 8 and used for method references.
    public static int findSquareOfMaxOddStream(List<Integer> numbers) {
        return numbers.stream()
                .filter(LambdaExpressionSamples::isOdd) // Predicate is functional interface and
                .filter(LambdaExpressionSamples::isGreaterThan3) // we are using lambdas to initialize it
                .filter(LambdaExpressionSamples::isLessThan11) // rather than anonymous inner classes
                .max(java.util.Comparator.naturalOrder())
                .map(i -> i * i)
                .get();
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static boolean isGreaterThan3(int i) {
        return i > 3;
    }

    public static boolean isLessThan11(int i) {
        return i < 11;
    }

    public static void lambdaExpressionExamples() {
		/*
		() -> {}                     // No parameters; void result
		() -> 42                     // No parameters, expression body
		() -> null                   // No parameters, expression body
		() -> { return 42; }         // No parameters, block body with return
		() -> { System.gc(); }       // No parameters, void block body
		
		// Complex block body with multiple returns
		() -> {
		  if (true) {
		  	return 10;
		  }else {
		    int result = 15;
		    for (int i = 1; i < 10; i++)
		      result *= i;
		    return result;
		  }
		}                          
		
		(int x) -> x+1             // Single declared-type argument
		(int x) -> { return x+1; } // same as above
		(x) -> x+1                 // Single inferred-type argument, same as below
		x -> x+1                   // Parenthesis optional for single inferred-type case
		
		(String s) -> s.length()   // Single declared-type argument
		(Thread t) -> { t.start(); } // Single declared-type argument
		s -> s.length()              // Single inferred-type argument
		t -> { t.start(); }          // Single inferred-type argument
		
		(int x, int y) -> x+y      // Multiple declared-type parameters
		(x,y) -> x+y               // Multiple inferred-type parameters
		(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
		(x, int y) -> x+y          // Illegal: can't mix inferred and declared types
		
		*/
    }

}
