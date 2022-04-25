package com.jasonz.database.request;

import com.jasonz.database.enity.UserRequest;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class Producer implements Runnable {
    // private int producerId = 0;
    private List<UserRequest> userRequests = null;
    private BlockingQueue<UserRequest>[] blockingQueues = null;
    private AtomicBoolean keepRunning = new AtomicBoolean(true);

    public Producer(List<UserRequest> userRequests, BlockingQueue<UserRequest>[] blockingQueues) {
        this.userRequests = userRequests;
        // this.producerId = userRequest.getId();
        this.blockingQueues = blockingQueues;
    }

    public void stop() {
        System.out.println("Producer has been stopped.");
        this.keepRunning.set(false);
    }

    public void updateRequests(List<UserRequest> userRequests){
        this.userRequests = userRequests;
    }

    @Override
    public void run() {
        try {
            while (keepRunning.get() == true) {
                for (UserRequest request : userRequests) {
                    blockingQueues[request.getId()%3].put(request);
                }
                this.keepRunning.set(false);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
