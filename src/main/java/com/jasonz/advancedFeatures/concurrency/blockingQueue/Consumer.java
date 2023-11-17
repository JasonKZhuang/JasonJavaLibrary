package com.jasonz.advancedFeatures.concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class Consumer extends AbstractConsumer implements Runnable {

    private BlockingQueue blockingQueue = null;

    // the constructor
    public Consumer(int threadId, BlockingQueue blockingQueue) {
        this.threadId = threadId;
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        String productionName = null;
        try {
            if (this.blockingQueue != null) {
                while (true) {
                    productionName = this.blockingQueue.take().toString();
                    System.out.println(String.format("Consumer [%s] has been take from Queue by thread [%d]", productionName, threadId));
                    sleep(3000L);
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
