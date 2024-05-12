package com.jasonz.advancedFeatures.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Jason Zhuang
 * @created 2024.02.29 10:21
 * @project JasonJavaLibrary
 * @description:
 */
public class SampleImpScheduledExecutorService {
    public static void main(String[] args) {
        SampleImpScheduledExecutorService ins = new SampleImpScheduledExecutorService();
        ins.handleScheduledThreadExecutor();
    }

    private void handleScheduledThreadExecutor() {

        // Create a ScheduledExecutorService with 2 threads.
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

        // Task 1: Scheduled to run after every 2 seconds with an initial delay of 1 second.
        Runnable task1 = () -> {
            System.out.println("Task 1 executed at: " + System.currentTimeMillis());
        };
        scheduledExecutor.scheduleWithFixedDelay(task1, 1, 2, TimeUnit.SECONDS);

        // Task 2: Scheduled to run after every 3 seconds with an initial delay of 2 seconds.
        Runnable task2 = () -> {
            System.out.println("Task 2 executed at: " + System.currentTimeMillis());
        };
        scheduledExecutor.scheduleWithFixedDelay(task2, 2, 3, TimeUnit.SECONDS);

        // Create a fixed thread pool executor for immediate task execution with 2 threads.
        var executor = Executors.newFixedThreadPool(2);

        // Immediate Task 1
        executor.execute(() -> {
            System.out.println("Immediate Task 1 executed at: " + System.currentTimeMillis());
        });

        // Immediate Task 2
        executor.execute(() -> {
            System.out.println("Immediate Task 2 executed at: " + System.currentTimeMillis());
        });

        // Shutdown executors after some time to stop the application.
        scheduledExecutor.schedule(() -> {
            System.out.println("Shutting down ScheduledExecutor...");
            scheduledExecutor.shutdown();
            try {
                if (!scheduledExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
                    scheduledExecutor.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduledExecutor.shutdownNow();
            }
        }, 10, TimeUnit.SECONDS);

        System.out.println(executor.isShutdown());
        System.out.println(scheduledExecutor.isShutdown());
    }

}
