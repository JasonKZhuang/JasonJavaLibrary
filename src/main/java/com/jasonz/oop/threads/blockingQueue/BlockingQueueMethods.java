package com.jasonz.oop.threads.blockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 */
public class BlockingQueueMethods {

    // define an BlockingQueue interface variable.
    private static BlockingQueue<String> blockingQueue = null;
    // define the capacity of the Blocking Queue
    private final int QUEUE_CAPACITY = 3;

    public static void main(String[] args) {
        BlockingQueueMethods m = new BlockingQueueMethods();
        // m.queueMethods();
        // m.dQueueMethods();
        // m.capacityMethods();
        // m.drainMethods();
    }

    private void queueMethods() {
        blockingQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // put()
        // will block until there is space inside the BlockingQueue for more element
        try {
            blockingQueue.put("testing");
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }

        // add()
        // will throw IllegalStateException if there is no space available in BlockingQueue
        try {
            blockingQueue.add("testing");
        } catch (IllegalStateException exp) {
            exp.printStackTrace();
        }

        // offer()
        // will return true or false if there is space or not, while adding a new element
        boolean wasEnqueued = blockingQueue.offer("testing");

        // offer(0, time, TimeUnit)
        // will block for a time if no space,
        // then returns false if still no space.
        try {
            boolean wasEnqueuedTime = blockingQueue.offer("testing", 1000l, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dQueueMethods() {
        blockingQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // take(),
        // Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
        // it will block until there is an element available in the Queue
        try {
            blockingQueue.take();
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }

        // poll()
        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        String v1 = blockingQueue.poll();

        // poll (timeout, TimeUnit)
        // Retrieves and removes the head of this queue, waiting up to the specified wait time if necessary for an element to become available.
        try {
            String v2 = blockingQueue.poll(1000l, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // remove(o)
        // Removes a single instance of the specified element from this queue, if it is present.
        boolean wasRemoved = blockingQueue.remove("testing");
    }

    private void pickingMethods() {
        blockingQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        // peek()
        // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        String v1 = blockingQueue.peek();

        // element()
        // Retrieves, but does not remove, the head of this queue.
        // This method differs from peek only in that it throws an exception if this queue is empty.
        try {
            String v2 = blockingQueue.element();
        } catch (NoSuchElementException exp) {
            exp.printStackTrace();
        }
    }

    private void capacityMethods() {
        blockingQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        int size = blockingQueue.size();

        int capacity = blockingQueue.remainingCapacity();

        boolean containsElement = blockingQueue.contains("testing");
    }

    private void drainMethods() {

        blockingQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        List<String> dest = new ArrayList<>();

        blockingQueue.drainTo(dest);

        blockingQueue.drainTo(dest, 3);
    }

}
