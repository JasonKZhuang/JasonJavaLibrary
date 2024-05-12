package com.jasonz.advancedFeatures.concurrency.threadCallable;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * In Java, a Callable is a functional interface defined in the java.util.concurrent package.
 * It's similar to Runnable, but it can return a result and can throw an exception.
 *
 * As you can see, it's a parameterized interface, where V is the type of the result returned by the call() method.
 * The call() method is where you define the task that the Callable will perform.
 * It returns a value of type V and can throw a checked exception of type Exception.
 *
 * Callable is often used in conjunction with the ExecutorService framework,
 * which allows you to submit tasks for execution asynchronously and manage their execution.
 *
 * Here's an example of how you might use Callable with an ExecutorService:
 *
 */
public class CallableExample {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of size 1
        ExecutorService es = Executors.newFixedThreadPool(1);

        // Create a Callable task by a lambda expression
        Callable<Integer> task = () -> {
            // Simulate some computation
            Thread.sleep(3000);
            return 42;
        };

        // Submit the Callable task to the ExecutorService for execution
        Future<Integer> future = es.submit(task);

        try {
            System.out.printf("Start to wait ... at %s%n",new Date());
            // Wait for the task to complete and get the result
            Integer result = future.get();
            System.out.printf("Result: %d    ... at %s%n ",result, new Date());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        // Shutdown the ExecutorService
        es.shutdown();
    }
}
