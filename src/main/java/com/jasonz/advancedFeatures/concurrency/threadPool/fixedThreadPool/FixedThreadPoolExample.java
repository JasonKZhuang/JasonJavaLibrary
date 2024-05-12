package com.jasonz.advancedFeatures.concurrency.threadPool.fixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Jason Zhuang
 * @date : 27/4/2022
 * @description :
 * Java线程池管理Runnable线程的集合。工作线程从队列中执行Runnable线程。
 * java.util.concurrent.Executors 为 java.util.concurrent.Executor 接口提供工厂和支持方法，以在java中创建线程池。
 * Executors是一个实用程序类，它还提供了通过各种工厂方法使用 ExecutorService，ScheduledExecutorService，ThreadFactory 和 Callable类的有用方法。
 */
public class FixedThreadPoolExample {

    /**
     * 这是测试程序类 从Executors框架创建固定线程池
     * 在上面的程序中，创建一个由5个工作线程组成的固定大小的线程池。
     * 然后向这个池提交了10个作业线程，因为池大小为5，它将开始处理5个作业，其他作业将处于等待状态，
     * 当其中一个作业完成，等待队列中的另一个作业将提到给工作线程接收并执行。
     * 池外排队，先进入，先处理
     * @param args
     */
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }
}
