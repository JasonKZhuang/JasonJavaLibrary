package com.jasonz.database.request;

import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class Producer implements Runnable {
    private static final int NUM_REQUESTS = 10000;
    private String producerName = null;
    private BlockingQueue[] blockingQueues;

    public Producer(String producerName, BlockingQueue[] blockingQueues) {
        this.producerName = producerName;
        this.blockingQueues = blockingQueues;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < NUM_REQUESTS; i++) {
                String useName = "user" + i;
                int idx = i % blockingQueues.length;
                blockingQueues[idx].put(useName);
                // if (i % 1000 == 0) {
                //     Thread.sleep(1000L);
                // }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
