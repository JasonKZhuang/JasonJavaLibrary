package com.jasonz.advancedFeatures.concurrency.threadPool.executorExample;

import com.jasonz.advancedFeatures.concurrency.threadPool.fixedPool.WorkerThread;

import java.util.concurrent.*;

/**
 * @author : Jason Zhuang
 * @date : 27/4/2022
 * @description :
 * Executors 类使用 ThreadPoolExecutor 提供 ExecutorService 的简单实现，
 * 但 ThreadPoolExecutor 提供了更多功能。
 * 可以指定在创建 ThreadPoolExecutor 实例时将处于活动状态的线程数，
 * 并且可以限制线程池的大小并创建自己的 RejectedExecutionHandler 实现来处理不适合工作队列的作业。
 * <p>
 * ThreadPoolExecutor提供了几种方法，可以使用它们找出执行程序的当前状态，池大小，活动线程数和任务计数。
 * 所以需要有一个监视器线程，它将以特定的时间间隔打印执行程序信息。
 */
public class ThreadPoolExecutorExample {

    public static void main(String args[]) throws InterruptedException {
        //RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        // 请注意，在初始化ThreadPoolExecutor时，
        // 初始池大小为2，最大池大小为4(最多会有4个线程来承接注入线程，并同时工作)，
        // 工作队列Queue的大小为 2
        // 因此，如果有4个正在运行的任务并且提交了更多任务，则工作队列将只保留其中的2个，
        // 其余的将由RejectedExecutionHandlerImpl处理。
        //creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);

        // ThreadPoolExecutor提供了几种方法，可以使用它们找出执行程序的当前状态，池大小，活动线程数和任务计数。
        // 所以需要有一个监视器线程，它将以特定的时间间隔打印执行程序信息
        // start the monitoring thread
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        //submit work to the thread pool
        for (int i = 1; i <= 10; i++) {
            executorPool.execute(new WorkerThread("cmd" + i));
        }

        // shut down the pool
        Thread.sleep(30000);
        executorPool.shutdown();

        // 请注意执行程序的活动，已完成和完成任务总数的更改。
        // 可以调用shutdown()方法来完成所有提交任务的执行并终止线程池。
        // shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();
    }

}
