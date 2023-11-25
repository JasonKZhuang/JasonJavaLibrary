package com.jasonz.dataStructures.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 16:17
 * @project JasonJavaLibrary
 * @description:
 */
public class BasicQueueExample {

    public void testingBasicQueueExample() {

        // Creating a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");
        queue.offer("David");

        // Printing the elements of the queue
        System.out.println("Original Queue: " + queue);

        // Removing and printing the front element (poll() method)
        String frontElement = queue.poll();
        System.out.println("Removed Front Element: " + frontElement);
        System.out.println("Queue after removal: " + queue);

        // Adding a new element to the back of the queue (offer() method)
        queue.offer("Eve");
        System.out.println("Queue after adding 'Eve': " + queue);

        // Peeking at the front element without removing it (peek() method)
        String peekedElement = queue.peek();
        System.out.println("Peeked Element: " + peekedElement);
        System.out.println("Queue after peeking: " + queue);
    }
}
