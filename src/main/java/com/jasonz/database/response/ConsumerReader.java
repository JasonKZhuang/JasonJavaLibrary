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
public class ConsumerReader extends ConsumerABS implements Runnable {
    private int consumerId = 0;
    private UserRequestRepository repository = null;
    private UserRequest userRequest;
    private BlockingQueue<UserRequest> blockingQueue = null;
    private AtomicBoolean keepRunning = new AtomicBoolean(true);
    private int countProcessed = 0;

    public ConsumerReader(UserRequest userRequest, UserRequestRepository repository, BlockingQueue<UserRequest> blockingQueue) {
        this.userRequest = userRequest;
        this.consumerId = userRequest.getUserId();
        this.repository = repository;
        this.blockingQueue = blockingQueue;
    }

    public void stop() {
        System.out.println(String.format("Consumer [%s] has been stopped.", consumerId));
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
                    //get the data from databased
                    UserRequest request = this.repository.getRecord(userRequest.getId());
                    if (request != null) {
                        System.out.println("\n Consumer " + Thread.currentThread().getName() + " : " + request.toString());
                    }
                    countProcessed++;
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        // System.out.println("===================================================");
        // System.out.println(Thread.currentThread().getName() + " stopped and finished " + countProcessed);
    }
}
