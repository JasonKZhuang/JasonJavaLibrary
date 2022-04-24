package com.jasonz.oop.threads.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class Producer extends AbstractProducer implements Runnable {

    private BlockingQueue blockingQueue = null;
    private int count = 0;

    // the constructor
    public Producer(int threadId, BlockingQueue blockingQueue) {
        this.threadId = threadId;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String productionName = null;
        try {
            if (this.blockingQueue != null) {
                while (true) {
                    productionName = "PRODCUTION + " + (++count);
                    this.blockingQueue.put(productionName);
                    System.out.println(String.format("[%s] has been put into Queue by thread [%d]", productionName, threadId));
                    sleep(2000L);
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
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
