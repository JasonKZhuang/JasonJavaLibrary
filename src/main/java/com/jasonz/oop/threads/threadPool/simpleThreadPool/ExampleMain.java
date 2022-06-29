package com.jasonz.oop.threads.threadPool.simpleThreadPool;

public class ExampleMain {

    private static int noOfThreads = 3;
    private static int maxNoOfTasks = 10000;

    public static void main(String[] args) throws Exception {

        // define a thread pool with number of threads and max number of tasks
        ThreadPool threadPool = new ThreadPool(noOfThreads, maxNoOfTasks);

        for (int i = 0; i < maxNoOfTasks; i++) {
            threadPool.execute(new ProductElement(i, "Task" + i));
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();

    }
}