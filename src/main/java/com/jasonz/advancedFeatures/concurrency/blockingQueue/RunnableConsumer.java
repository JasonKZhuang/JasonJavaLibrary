package com.jasonz.advancedFeatures.concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class RunnableConsumer extends AbstractConsumer implements Runnable {

    private BlockingQueue<String> blockingQueue = null;

    private AtomicBoolean keepRunning = new AtomicBoolean(true);

    // the constructor
    public RunnableConsumer(int threadId, BlockingQueue<String> blockingQueue) {
        this.threadId = threadId;
        this.blockingQueue = blockingQueue;
    }

    public void stop() {
        System.out.println(Thread.currentThread().getName() + " is stopped.");
        this.keepRunning.set(false);
    }

    @Override
    public void run() {
        this.threadName = Thread.currentThread().getName();
        System.out.println(String.format("[%s] started and waiting for ...", threadName));
        System.out.println("==========================================================");
        try {
            while (this.keepRunning.get() == true) {
                String value = takeObjectFromQueue();
                if (value == null) {
                    this.stop();
                } else {
                    System.out.println("Consuming " + value + " by " + threadName);
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
            this.stop();
        }
        // while (this.blockingQueue.size() > 0) {
        //     String value = takeObjectFromQueue();
        //     System.out.println(String.format("ConsumerThread [%d] takes value [%s].", threadId, value));
        // }
    }

    private String takeObjectFromQueue() {
        try {
            return blockingQueue.poll(10 * 1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("waiting time runs out, " + this.threadName + " stopped.");
            return null;
        }
    }
}
