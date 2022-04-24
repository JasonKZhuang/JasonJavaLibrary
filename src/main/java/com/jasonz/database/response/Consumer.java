package com.jasonz.database.response;

import com.jasonz.database.repository.ProductRepository;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class Consumer implements Runnable {
    private String useName = null;
    private ProductRepository repository = null;
    private BlockingQueue<String> blockingQueue = null;
    private AtomicBoolean keepRunning = new AtomicBoolean(true);
    private int countProcessed = 0;

    public Consumer(String useName, ProductRepository repository, BlockingQueue<String> blockingQueue) {
        this.useName = useName;
        this.repository = repository;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String userName = null;
        while (this.keepRunning.get()) {
            try {
                userName = blockingQueue.poll(5 * 1000L, TimeUnit.MILLISECONDS);
                if (userName == null) {
                    this.keepRunning.set(false);
                } else {
                    System.out.println("Consumer " + userName + " try to get data from db by " + Thread.currentThread().getName());
                    //get the data from database
                    this.repository.getRecords();
                    countProcessed ++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("===================================================");
        System.out.println(Thread.currentThread().getName() + " stopped and finished " + countProcessed +" accessiong");
    }
}
