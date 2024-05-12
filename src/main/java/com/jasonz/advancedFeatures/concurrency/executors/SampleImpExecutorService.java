package com.jasonz.advancedFeatures.concurrency.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jason Zhuang
 * @created 2024.02.29 10:21
 * @project JasonJavaLibrary
 * @description: submit accepts Runnable objects, but also accepts Callable objects,
 * which allow the task to return a value.
 * <p>
 * The submit method returns a Future object,
 * which is used to retrieve the Callable return value and to manage the status of both Callable and Runnable tasks.
 */
@Slf4j
public class SampleImpExecutorService {

    public static void main(String[] args) {

        SampleImpExecutorService test = new SampleImpExecutorService();
        test.handleMonitorThreadPool();
        //test.handleSingleThreadExecutor();
        //test.handleInvokeAllMethod();

    }

    private void handleMonitorThreadPool() {

        // Create a fixed thread pool executor for immediate task execution with 2 threads.
        // ExecutorService executor = Executors.newFixedThreadPool(2);
        int queueCapacity = 10;
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 3;
        AtomicInteger activeTaskCount = new AtomicInteger();
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(queueCapacity);
        try {
            // create ThreadPoolExecutor with above parameters
            ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
                    maximumPoolSize,
                    keepAliveTime,
                    unit,
                    workQueue);

            // Monitor the ThreadPoolExecutor in a separate thread.
            Thread monitorThread = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        activeTaskCount.set(executor.getActiveCount());
                        System.out.println("==============================================================");
                        System.out.println("Current Pool Size: " + executor.getPoolSize());
                        System.out.println("Number of Active Threads: " + activeTaskCount.get());
                        System.out.println("Number of Tasks Completed: " + executor.getCompletedTaskCount());
                        System.out.println("Number of Tasks in Queue: " + executor.getQueue().size());

                        Thread.sleep(1000);

                        if (activeTaskCount.get()<maximumPoolSize){
                            notifyAll();
                        }
                        System.out.println("==============================================================");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            // Start the monitoring thread.
            log.info("The monitor thread started.");
            monitorThread.start();

            // Prepare BlockingQueue and ask executor to execute task
            for (int i = 0; i < 100; i++) {
                MyThreadTask task = new MyThreadTask("task-" + i, (taskItem) -> {
                    return "Lambda Result for " + taskItem;
                });

                if (activeTaskCount.get() >= maximumPoolSize) {
                    wait();
                }

                executor.execute(task);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }


    }

    /**
     * Creates an Executor that uses a single worker thread operating off an unbounded queue
     */
    private void handleSingleThreadExecutor() {

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.submit(() -> {
            System.out.println("Task 1");
            throw new RuntimeException();
        });

        service.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task 2");
        });

        service.submit(() -> System.out.println("Task 3"));

        service.shutdown();
    }

    /**
     * As per the Java SE API Specification,
     * the invokeAll method executes the given tasks,
     * returning a list of futures holding their status and results when all complete.
     * <p>
     * Future.isDone() is true for each element of the returned list.
     * Note that a completed task could have terminated either normally or by throwing an exception.
     */
    private void handleInvokeAllMethod() {

        ExecutorService service = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> "Task completed";

        Callable<String> task2 = () -> {
            throw new RuntimeException();
        };

        Callable<String> task3 = () -> {
            Thread.sleep(10_000);
            return null;
        };

        try {
            var result = service.invokeAll(List.of(task1, task2, task3));
            System.out.println(result.get(0).get());
            service.shutdown();
        } catch (ExecutionException | InterruptedException exp) {
            throw new RuntimeException(exp);
        }

    }


}
