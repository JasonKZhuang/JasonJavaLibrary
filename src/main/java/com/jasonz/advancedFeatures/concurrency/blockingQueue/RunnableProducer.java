package com.jasonz.advancedFeatures.concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class RunnableProducer extends AbstractProducer implements Runnable {

    int numOfProducing = 5000;

    private BlockingQueue<String> blockingQueue = null;

    // the constructor
    public RunnableProducer(int threadId, BlockingQueue<String> blockingQueue) {
        this.threadId = threadId;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numOfProducing; i++) {
                String productName = "Object " + i;
                this.blockingQueue.put(productName);
                System.out.println("Producing " + productName);
                if (i % 1000 == 0) {
                    sleep(2000L);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep(long mSecond) {
        try {
            Thread.sleep(mSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
