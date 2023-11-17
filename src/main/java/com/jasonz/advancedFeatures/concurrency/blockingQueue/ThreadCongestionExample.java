package com.jasonz.advancedFeatures.concurrency.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class ThreadCongestionExample {

    // define an BlockingQueue interface variable.
    private static BlockingQueue<String> blockingQueue = null;
    // define the capacity of the Blocking Queue
    private final int QUEUE_CAPACITY = 50;
    // define how many producer
    private final int NUM_PRODUCERS = 1;
    // define how many queue
    private final int NUM_QUEUES = 1;
    // define how many consumers
    private final int NUM_CONSUMERS = 3;
    // define how many products to be produced
    private final int NUM_PROCESSED = 10000;

    public static void main(String[] args) {
        ThreadCongestionExample instance = new ThreadCongestionExample();
        // instance.testOneQueueMultiConsumers();
        instance.testMultiQueuesMultiConsumers();
    }

    /**
     * this method it to test the situation where
     * One Producer
     * Multi Queues
     * Multi Consumers
     */
    private void testMultiQueuesMultiConsumers() {
        int numOfConsumers = 3;
        // create three array blocking queues
        BlockingQueue<String>[] blockingQueues = new BlockingQueue[numOfConsumers];
        for (int i = 0; i < blockingQueues.length; i++) {
            blockingQueues[i] = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        }

        // create three consumers array
        RunnableConsumer[] consumers = new RunnableConsumer[numOfConsumers];
        // assign consumers to array
        synchronized (this.getClass()) {
            for (int i = 0; i < consumers.length; i++) {
                // passing mapping blocking queue to mapping consumer
                consumers[i] = new RunnableConsumer(i, blockingQueues[i]);
                Thread threadConsumer = new Thread(consumers[i]);
                threadConsumer.start();
            }
        }

        // create a producer
        Thread producerThread = new Thread(() -> {
            int queueIdx = 0;
            try {
                for (int i = 0; i <= NUM_PROCESSED; i++) {
                    queueIdx = i % blockingQueues.length;
                    String productName = "Object " + i;
                    blockingQueues[queueIdx].put(productName);
                    // System.out.println("Producing " + productName);
                    if (i % 1000 == 0) {
                        Thread.sleep(2000L);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producerThread.start();
    }

    /**
     * this method it to test the situation where
     * One Producer
     * One Queue
     * Multi Consumers
     * refer to the chapter Java Concurrency and Multithreading in my Java Tech document
     */
    private void testOneQueueMultiConsumers() {

        // create an array blocking queue
        blockingQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // create multi consumers array
        RunnableConsumer[] consumers = new RunnableConsumer[NUM_CONSUMERS];
        // assign consumers to array
        synchronized (this.getClass()) {
            for (int i = 0; i < consumers.length; i++) {
                consumers[i] = new RunnableConsumer(i, blockingQueue);
                Thread threadConsumer = new Thread(consumers[i]);
                threadConsumer.start();
            }
        }

        // create a producer
        RunnableProducer producer = new RunnableProducer(1, blockingQueue);
        Thread threadProducer = new Thread(producer);
        threadProducer.start();
    }


}
