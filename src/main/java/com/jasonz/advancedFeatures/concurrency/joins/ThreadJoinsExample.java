package com.jasonz.advancedFeatures.concurrency.joins;

/**
 * @author Jason Zhuang
 * @created 2024.05.09 13:12
 * @project JasonJavaLibrary
 * @description:
 */
public class ThreadJoinsExample implements Runnable {

    private final String threadName;
    private final Thread joinedThread;

    public ThreadJoinsExample(String threadName, Thread joinedThread) {
        this.threadName = threadName;
        this.joinedThread = joinedThread;
    }

    @Override
    public void run() {
        try {
            joinedThread.join(1000);
            System.out.println("Joined Thread: " + threadName + " is joined with " + joinedThread.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
