package com.jasonz.advancedFeatures.concurrency.pausingExecution;

/**
 * @author Jason Zhuang
 * @created 2024.04.03 10:54
 * @project JasonJavaLibrary
 * @description:
 * This example involves two threads:
 * a producer that produces a message and a consumer that consumes it.
 * The producer and consumer communicate via a shared object (Message).
 * The consumer waits until the producer posts a message,
 * and the producer notifies the consumer after posting the message.
 */
public class UsingObjectWait {

    public static void main(String[] args) {
        Message message = new Message();
        //
        Thread consumer = new Thread(new Consumer(message));
        consumer.start();
        //
        Thread producer = new Thread(new Producer(message));
        producer.start();

    }


}
