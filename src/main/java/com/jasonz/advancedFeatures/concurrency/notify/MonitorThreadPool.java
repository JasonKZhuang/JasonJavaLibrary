package com.jasonz.advancedFeatures.concurrency.notify;

import com.jasonz.advancedFeatures.concurrency.executors.MyThreadTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jason Zhuang
 * @created 2024.04.19 15:14
 * @project JasonJavaLibrary
 * @description:
 */
public class MonitorThreadPool {
    private final Object lock = new Object();
    private final int queueCapacity = 10;
    private final int corePoolSize = 2;
    private final int maximumPoolSize = 4;
    private final long keepAliveTime = 3;
    private final TimeUnit unit = TimeUnit.SECONDS;
    private boolean isPoolAvailable = false;
    private AtomicInteger activeTaskCount = new AtomicInteger();
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(queueCapacity);
    private ThreadPoolExecutor executor;

    /**
     * constructor
     */
    MonitorThreadPool() {
        this.executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue);
    }

    public static void main(String[] args) {

        MonitorThreadPool instance = new MonitorThreadPool();

        Thread myMonitorThread = new Thread(instance::monitorThreadPool);

        Thread myProducerThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        myMonitorThread.start();
        myProducerThread.start();

    }

    private void produceThread() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    while (!isPoolAvailable) {
                        lock.wait();  // Wait until the consumer consumes
                    }
                    MyThreadTask task = new MyThreadTask("task-" + i, (taskItem) -> {
                        return "Lambda Result for " + taskItem;
                    });
                    executor.execute(task);
                    isPoolAvailable = false;
                    lock.notify();  // Notify the consumer that an item is available
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void monitorThreadPool() {
        try {
            synchronized (lock) {
                while (!Thread.currentThread().isInterrupted()) {
                    activeTaskCount.set(executor.getActiveCount());
                    System.out.println("==============================================================");
                    System.out.println("Pool MaxSize: " + executor.getMaximumPoolSize());
                    System.out.println("Current Pool Size: " + executor.getPoolSize());
                    System.out.println("Number of Active Threads: " + activeTaskCount.get());
                    System.out.println("Number of Tasks Completed: " + executor.getCompletedTaskCount());
                    System.out.println("Number of Tasks in Queue: " + executor.getQueue().size());

                    Thread.sleep(1000);

                    if (activeTaskCount.get() < maximumPoolSize && !isPoolAvailable ) {
                        isPoolAvailable = true;
                        lock.notify();
                    }

                    System.out.println("==============================================================");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
