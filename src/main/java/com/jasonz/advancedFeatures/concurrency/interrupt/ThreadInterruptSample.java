package com.jasonz.advancedFeatures.concurrency.interrupt;

import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDateTime;

/**
 * @author Jason Zhuang
 * @created 2024.05.09 12:37
 * @project JasonJavaLibrary
 * @description:
 */
@Getter
public class ThreadInterruptSample implements Runnable {

    private final String threadName;

    public ThreadInterruptSample(String threadName) {
        this.threadName = threadName;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Intended interrupted Thread: " + threadName + " is running... at " + LocalDateTime.now()
                    + " and waiting for to be interrupted...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Intended interrupted Thread: " + threadName + " is interrupted...");
                // we can throw RuntimeException here to stop the thread
                //throw new RuntimeException(e);
                // or we can break the loop to stop the thread
                break;
            }
        }
    }
}
