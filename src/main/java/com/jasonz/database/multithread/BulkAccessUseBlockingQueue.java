package com.jasonz.database.multithread;

import com.jasonz.database.enity.UserRequest;
import com.jasonz.database.repository.UserRequestRepository;
import com.jasonz.database.request.Producer;
import com.jasonz.database.response.ConsumerReader;
import com.jasonz.database.response.ConsumerWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
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

    private UserRequestRepository repository = null;
    private BlockingQueue<UserRequest>[] blockingQueues = null;
    private ConsumerReader[] consumerReaders = null;
    private ConsumerWriter[] consumerWriters = null;
    private Producer[] producers = null;

    public static void main(String[] args) {
        BulkAccessUseBlockingQueue instance = new BulkAccessUseBlockingQueue();
        instance.bulkRead();
        // instance.bulkWrite();
    }

    private void bulkRead() {
        repository = new UserRequestRepository();
        blockingQueues = new ArrayBlockingQueue[NUM_QUEUES];
        consumerReaders = new ConsumerReader[NUM_QUEUES];

        //initial three blocking queues and three consumers
        int capacity = MAX_CONNECTIONS / NUM_QUEUES;
        UserRequest userRequest = new UserRequest();
        for (int i = 0; i < blockingQueues.length; i++) {
            blockingQueues[i] = new ArrayBlockingQueue<>(capacity);
            ConsumerReader consumer = new ConsumerReader(userRequest, repository, blockingQueues[i]);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }

        Scanner scanner = new Scanner(System.in);
        int numRequests = 0;
        while (true) {
            System.out.print("input how many requests created: ");
            numRequests = scanner.nextInt();
            if (numRequests == 0) { // exit
                stopProducers();
                stopConsumers();
                System.exit(0);
            }

            // prepare requests
            List<UserRequest> userRequests = new ArrayList<>();
            for (int i = 1; i <= numRequests; i++) {
                UserRequest request = new UserRequest();
                request.setId(i);
                request.setUserId(i);
                request.setProductId(i);
                // request.setContent(getMyPhoto());
                request.setCreateOn(new Date());
                request.setUpdateOn(new Date());
                userRequests.add(request);
            }
            //initial one producer to allocate user requests
            Producer producer = new Producer(userRequests, blockingQueues);
            Thread producerThread = new Thread(producer);
            producerThread.start();
        }

    }

    private void bulkWrite() {
        repository = new UserRequestRepository();
        blockingQueues = new ArrayBlockingQueue[NUM_QUEUES];
        consumerWriters = new ConsumerWriter[NUM_QUEUES];

        //initial three blocking queues and three consumers
        int capacity = MAX_CONNECTIONS / NUM_QUEUES;
        for (int i = 0; i < blockingQueues.length; i++) {
            blockingQueues[i] = new ArrayBlockingQueue<>(capacity);
            ConsumerWriter consumer = new ConsumerWriter(new UserRequest(), repository, blockingQueues[i]);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }

        Scanner scanner = new Scanner(System.in);
        int numRequests = 0;
        while (true) {
            System.out.print("input how many requests created: ");
            numRequests = scanner.nextInt();

            if (numRequests == 0) { // exit
                stopProducers();
                stopConsumers();
                System.exit(0);
            }

            // prepare requests
            List<UserRequest> userRequests = new ArrayList<>();
            for (int i = 1; i <= numRequests; i++) {
                UserRequest request = new UserRequest();
                request.setId(i);
                request.setUserId(i);
                request.setProductId(i);
                request.setContent(getMyPhoto());
                request.setCreateOn(new Date());
                request.setUpdateOn(new Date());
                userRequests.add(request);
            }

            //initial one producer to allocate user requests
            Producer producer = new Producer(userRequests, blockingQueues);
            Thread producerThread = new Thread(producer);
            producerThread.start();
        }
    }

    private void stopProducers() {
        if (producers != null && producers.length > 0) {
            for (int i = 0; i < producers.length; i++) {
                if (producers[i] != null) {
                    producers[i].stop();
                }
            }
        }
    }

    private void stopConsumers() {
        if (consumerReaders != null && consumerReaders.length > 0) {
            for (int i = 0; i < consumerReaders.length; i++) {
                if (consumerReaders[i] != null) {
                    consumerReaders[i].stop();
                }
            }
        }
        if (consumerWriters != null && consumerWriters.length > 0) {
            for (int i = 0; i < consumerWriters.length; i++) {
                if (consumerWriters[i] != null) {
                    consumerWriters[i].stop();
                }
            }
        }
    }

    private InputStream getMyPhoto(){
        InputStream is = null;
        try{
            String currentPath = new File(".").getCanonicalPath();
            String photoName = currentPath + "/myself.jpg";
            is = new FileInputStream(photoName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

}
