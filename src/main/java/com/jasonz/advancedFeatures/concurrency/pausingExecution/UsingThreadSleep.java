package com.jasonz.advancedFeatures.concurrency.pausingExecution;

import lombok.Getter;

/**
 * @author Jason Zhuang
 * @created 2024.04.03 10:52
 * @project JasonJavaLibrary
 * @description:
 * very basic way to pause running thread
 */
@Getter
public class UsingThreadSleep implements Runnable{

    private final String threadName;

    public UsingThreadSleep(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "Lesson6Distinct kid will eat ivy too"
        };

        for (String s : importantInfo) {
            //Pause for 4 seconds
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //We've been interrupted: no more messages.
                return;
            }
            //Print a message
            System.out.println("My Sleep Thread is reading message: " + s + " ...");
        }
    }
}
