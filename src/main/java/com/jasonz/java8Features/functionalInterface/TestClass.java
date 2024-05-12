package com.jasonz.java8Features.functionalInterface;

import com.jasonz.dto.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.*;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 09:40
 * @project JasonJavaLibrary
 * @description:
 * @references: https://jenkov.com/tutorials/java-functional-programming/functional-interfaces.html
 */
public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        testClass.testSingleAbstractMethodInFunctionalInterface();
        testClass.testDefaultMethodsInFunctionalInterface();
        testClass.testStaticMethodsInFunctionalInterface();
        testClass.testLambdaExpressionInFunctionalInterface();
        testClass.testUtilizingJavaGivenFunctionInterface();
        testClass.testPredicate();
        testClass.testSupplierAndConsumer();
        testClass.testUnaryOperator();
        testClass.testBinaryOperator();


    }

    private void testSingleAbstractMethodInFunctionalInterface() {
        MyImplementationClass myClass = new MyImplementationClass();
        myClass.singleAbstractMethod();
    }

    private void testDefaultMethodsInFunctionalInterface() {
        MyImplementationClass myClass = new MyImplementationClass();
        myClass.defaultMethodWithImplementation1("Hello defaultMethodWithImplementation1");
        myClass.defaultMethodWithImplementation2("Hello defaultMethodWithImplementation2");
    }

    private void testStaticMethodsInFunctionalInterface() {
        try {
            PrintWriter writer = new PrintWriter("output.txt", StandardCharsets.UTF_8);
            MyFunctionalInterfaceSub.staticMethodWithImplementation1(
                    "Hello staticMethodWithImplementation11111 \n",
                    writer
            );

            MyFunctionalInterfaceSub.staticMethodWithImplementation2(
                    "Hello staticMethodWithImplementation22222 \n",
                    writer
            );

            writer.printf("Number with two decimal places: %.2f \n", 123.4567);

            // Flushing the writer to ensure all data is written out to the file
            writer.flush();

            // Closing the writer
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void testLambdaExpressionInFunctionalInterface() {
        // this is an implementation (lambda expression) of single abstract method in MyFunctionalInterface
        MyFunctionalInterface lambda = () -> {
            System.out.println("Executing inside single abstract method...");
        };
        // this is call the single abstract method
        lambda.singleAbstractMethod();
    }

    // ==================================================== //
    private long calculate(int factor, Function<Integer, Long> func) {
        return func.apply(factor);
    }
    private void testCalculate(){
        int factor = 2;
        long v = 0 ;
        // this error because the function take Integer parameter and must return Long
        // long v = calculate(3, x -> factor * x);
        System.out.println(v);
    }
    // ==================================================== //

    private void testUtilizingJavaGivenFunctionInterface() {
        AddThreeImplementFunction addThreeImplementFunction = new AddThreeImplementFunction();
        System.out.println(addThreeImplementFunction.apply(123));

        // You can also implement the Function interface using a Java lambda expression.
        // Here is how that looks:
        Function<Long, String> adder = (value) -> String.valueOf(value + 3);
        String resultLambda = adder.apply(8L);
        System.out.println("resultLambda = " + resultLambda);
    }

    /**
     * The Java Predicate interface, java.util.function.Predicate,
     * represents a simple function that takes a single value as parameter,
     * and returns true or false.
     * Here is how the Predicate functional interface definition looks:
     *
     * @return
     */
    private boolean testPredicate() {
        String myStr = "abcdsssss";
        Predicate<String> predicate = (v) -> {
            if (v.length() > 113) {
                return true;
            }
            return false;
        };
        boolean retBoolean = predicate.test(myStr);
        System.out.println(retBoolean);
        return retBoolean;
    }

    /**
     * The Java UnaryOperator interface is a functional interface
     * that represents an operation which takes a single parameter and returns a parameter of the same type.
     * Here is an example of a Java UnaryOperator implementation:
     */
    private void testUnaryOperator() {
        Product oldProduct = new Product(
                1,
                "iPhone14",
                45.6,
                1000,
                new Date(),
                "this is new iphone 14"
        );
        System.out.println(oldProduct);
        UnaryOperator<Product> unaryOperator =
                (product) -> {
                    product.setId(101);
                    product.setName("new Product");
                    product.setPrice(123.89);
                    return product;
                };

        Product newProduct = unaryOperator.apply(oldProduct);
        System.out.println(newProduct);

    }

    /**
     * The Java BinaryOperator interface is a functional interface that represents an
     * operation which takes two parameters and returns a single value.
     * Both parameters and the return type must be of the same type.
     * <p>
     * The Java BinaryOperator interface is useful
     * when implementing functions that sum, subtract, divide, multiply etc. two elements of the same type,
     * and returns a third element of the same type.
     * <p>
     * Here is an example implementation of the BinaryOperator interface:
     */
    private void testBinaryOperator() {
        Product oldProductA = new Product(
                1,
                "iPhone14",
                45.6,
                400,
                new Date(),
                "this is new iphone 14"
        );
        Product oldProductB = new Product(
                1,
                "iPhone14",
                45.6,
                600,
                new Date(),
                "this is new iphone 14"
        );

        BinaryOperator<Product> binaryOperator =
                (product1, product2) -> {
                    product1.setNum(product2.getNum());
                    return product1;
                };

        // this newProduct variable has the same pointer with oldProductA
        Product newProduct = binaryOperator.apply(oldProductA, oldProductB);
        System.out.println(newProduct);
    }

    /**
     * The Java Supplier interface is a functional interface that represents an function that supplies a value of some sorts.
     * The Supplier interface can also be thought of as a factory interface.
     * <p>
     * The Java Consumer interface is a functional interface that represents an function that consumes a value without returning any value.
     * Lesson6Distinct Java Consumer implementation could be printing out a value, or writing it to a file, or over the network etc.
     * <p>
     * Here are example implementations of the Java Supplier and Consumer interfaces:
     */
    private void testSupplierAndConsumer() {

        Supplier<Integer> supplier = () -> (int) (Math.random() * 1000D);
        int myRandomInt = supplier.get();

        Consumer<Integer> consumer = (value) -> {
            System.out.println("========================");
            System.out.printf("This is only consume value [%d], not return value.%n", value);
            System.out.println("========================");
        };
        consumer.accept(myRandomInt);

    }
}
