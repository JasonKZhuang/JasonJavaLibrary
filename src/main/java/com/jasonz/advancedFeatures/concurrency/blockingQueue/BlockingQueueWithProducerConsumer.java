package com.jasonz.advancedFeatures.concurrency.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class BlockingQueueWithProducerConsumer {

    // define an BlockingQueue interface variable.
    private static BlockingQueue<String> blockingQueue = null;
    // define the capacity of the Blocking Queue
    private final int QUEUE_CAPACITY = 3;

    public static void main(String[] args) {
        BlockingQueueWithProducerConsumer ins = new BlockingQueueWithProducerConsumer();
        ins.testArrayBlockQueue();
    }

    private void testArrayBlockQueue() {

        //create an ArrayBlockingQueue with the given (fixed) capacity.
        blockingQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);

        try {
            Producer producer = new Producer(1, blockingQueue);
            Consumer consumer = new Consumer(1, blockingQueue);

            Thread pThread = new Thread(producer);
            Thread cThread = new Thread(consumer);

            pThread.start();
            cThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
