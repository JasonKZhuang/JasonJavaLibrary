package com.jasonz.database.multithread;

import com.jasonz.database.repository.ProductRepository;
import com.jasonz.database.request.Producer;
import com.jasonz.database.response.Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class BulkAccessUseBlockingQueue {
    private static final int MAX_CONNECTIONS = 150;
    private static final int NUM_QUEUES = 3;

    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();

        BlockingQueue<String>[] blockingQueues = new ArrayBlockingQueue[NUM_QUEUES];
        int capacity = MAX_CONNECTIONS / NUM_QUEUES;
        for (int i = 0; i < blockingQueues.length; i++) {
            blockingQueues[i] = new ArrayBlockingQueue<>(capacity);
            Consumer consumer = new Consumer("user" + i, repository, blockingQueues[i]);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }

        Producer producer = new Producer("requests", blockingQueues);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        // ProductRepository repository = new ProductRepository();
        // repository.getRecords();

    }
}
