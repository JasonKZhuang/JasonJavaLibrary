package com.jasonz.dataStructures.collection.list.vector;

import java.util.Vector;

public class AddToSharedListThread implements Runnable {
    private Vector<String> sharedList;
    private String threadName;

    public AddToSharedListThread(Vector<String> sharedList, String threadName) {
        this.sharedList = sharedList;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String element = threadName + ": Element " + i;
            sharedList.add(element);
            System.out.println(threadName + " added: " + element);

            // Simulating some processing time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
