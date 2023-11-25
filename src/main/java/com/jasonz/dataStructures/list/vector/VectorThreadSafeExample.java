package com.jasonz.dataStructures.list.vector;

import java.util.Vector;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 15:37
 * @project JasonJavaLibrary
 * @description:
 * In this example, two threads (Thread 1 and Thread 2) are simultaneously adding elements to a shared Vector.
 * The use of Vector ensures that the operations on the shared list are synchronized,
 * preventing potential issues that could arise from concurrent modifications by multiple threads.
 *
 * It's important to note that while Vector provides thread safety, it may introduce some performance overhead.
 * If you are working in a single-threaded environment or
 * if you can ensure thread safety through other means (such as explicit synchronization),
 * you might consider using ArrayList or other non-synchronized collections for better performance.
 */
public class VectorThreadSafeExample {

    public static void main(String[] args) {
        // Creating a shared Vector
        Vector<String> sharedList = new Vector<>();

        // Creating and starting multiple threads
        Thread thread1 = new Thread(new AddToSharedListThread(sharedList, "Thread 1"));
        Thread thread2 = new Thread(new AddToSharedListThread(sharedList, "Thread 2"));

        thread1.start();
        thread2.start();

        // Waiting for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Displaying the final contents of the shared list
        System.out.println("Final Shared List: " + sharedList);
    }
}

