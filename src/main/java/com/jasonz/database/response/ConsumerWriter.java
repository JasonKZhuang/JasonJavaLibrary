package com.jasonz.database.response;

import com.jasonz.database.enity.UserRequest;
import com.jasonz.database.repository.UserRequestRepository;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class ConsumerWriter extends ConsumerABS implements Runnable {
    private int consumerName = 0;
    private UserRequestRepository repository = null;
    private UserRequest userRequest;
    private BlockingQueue<UserRequest> blockingQueue = null;
    private AtomicBoolean keepRunning = new AtomicBoolean(true);
    private int countProcessed = 0;

    public ConsumerWriter(UserRequest userRequest, UserRequestRepository repository, BlockingQueue<UserRequest> blockingQueue) {
        this.userRequest = userRequest;
        this.consumerName = userRequest.getUserId();
        this.repository = repository;
        this.blockingQueue = blockingQueue;
    }

    public void stop() {
        System.out.println(String.format("Consumer [%s] has been stopped.", consumerName));
        this.keepRunning.set(false);
    }

    @Override
    public void run() {
        while (this.keepRunning.get()) {
            try {
                userRequest = blockingQueue.poll();
                if (userRequest == null || userRequest.getId() == 0) {
                    // this.keepRunning.set(false);
                } else {
                    //save the data from database
                    this.repository.saveRecords(userRequest);
                    System.out.println("\n" + Thread.currentThread().getName() + " save data " + userRequest.toString());
                    countProcessed++;
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " stopped and finished " + countProcessed);
    }
}
