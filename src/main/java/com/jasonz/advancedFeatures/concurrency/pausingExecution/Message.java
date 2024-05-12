package com.jasonz.advancedFeatures.concurrency.pausingExecution;

/**
 * @author Jason Zhuang
 * @created 2024.04.03 10:55
 * @project JasonJavaLibrary
 * @description:
 */
class Message {

    private String message;
    private boolean empty = true;

    // synchronized means there is only one thread can access this method at the same time
    public synchronized String take() {
        // Wait until message is available
        while (empty) {
            try {
                System.out.println("You need to wait until the message pool has value...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Toggle status and notify all waiting threads (usually the producer)
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        // Wait until message has been taken
        while (!empty) {
            try {
                System.out.println("You need to wait until the message pool is empty...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Toggle status, set message, and notify all waiting threads (usually the consumer)
        empty = false;
        this.message = message;

        // Wakes up all threads that are waiting on this object's monitor.
        // Lesson6Distinct thread waits on an object's monitor by calling one of the wait methods.
        notifyAll();
    }
}
