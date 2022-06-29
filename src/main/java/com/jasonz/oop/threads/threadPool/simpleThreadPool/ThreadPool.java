package com.jasonz.oop.threads.threadPool.simpleThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    // Tasks in a Queue
    private BlockingQueue<ProductElement> taskQueue = null;
    // Multiple Runnable Threads in the Pool
    private List<PoolRunnableThread> threads = new ArrayList<>();
    // stop flag
    private boolean isStopped = false;

    // construction with number of threads and max number of tasks
    public ThreadPool(int noOfThreads, int maxNoOfTasks) {

        //create a blocking queue with capacity
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

        // store all threads in a list
        for (int i = 0; i < noOfThreads; i++) {
            PoolRunnableThread runnableThread = new PoolRunnableThread(taskQueue);
            threads.add(runnableThread);
        }
        // start running the thread
        for (PoolRunnableThread thread : threads) {
            new Thread(thread).start();
        }
    }

    // //Inserts the specified element into this queue
    public synchronized void execute(ProductElement task) throws Exception {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        //Inserts the specified element into this queue
        this.taskQueue.offer(task);
        System.out.println(this.taskQueue.size());
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (PoolRunnableThread runnable : threads) {
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}