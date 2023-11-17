package com.jasonz.advancedFeatures.concurrency.threadPool.simpleThreadPool;

import java.util.concurrent.BlockingQueue;

/**
 * the PoolThreadRunnable class which implements the Runnable interface,
 * so it can be executed by a Java thread
 */
public class PoolRunnableThread implements Runnable {

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    /**
     * construction with a blocking queue
     *
     * @param queue
     */
    public PoolRunnableThread(BlockingQueue queue) {
        taskQueue = queue;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        String threadName = this.thread.getName();
        while (!this.isStopped()) {
            try {
                // get the element from queue
                ProductElement element = (ProductElement) taskQueue.take();
                System.out.println(threadName + ":" + element.getName() + " is taken to be processed.");
            } catch (Exception e) {
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        //break pool thread out of dequeue() call.
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}