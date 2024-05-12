package com.jasonz.advancedFeatures.concurrency.basic;

import com.jasonz.advancedFeatures.concurrency.ThreadConstant;

import java.util.Map;

/**
 * @author Jason Zhuang
 * @created 2024.05.09 12:23
 * @project JasonJavaLibrary
 * @description:
 */
public class HandleMultipleThreadsOperation implements Runnable {

    private final Map<String, Thread> threads;
    private int count = 0;

    public HandleMultipleThreadsOperation(Map<String, Thread> threads) {
        this.threads = threads;
    }


    @Override
    public void run() {

        for (Map.Entry<String, Thread> entry : threads.entrySet()) {
            entry.getValue().start();
        }
        System.out.println("All threads are started...");

        try {
            while (true) {
                Thread t = threads.get(ThreadConstant.THREAD_NAME_INTERRUPT);
                if (t.isAlive() && count > 3) {
                    t.interrupt();
                    break;
                }
                Thread.sleep(5000);
                count++;

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
