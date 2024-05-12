package com.jasonz.advancedFeatures.concurrency.basic;

import lombok.Getter;

/**
 * @author Jason Zhuang
 * @created 2024.05.09 11:56
 * @project JasonJavaLibrary
 * @description:
 */
@Getter
public class HelloRunnable implements Runnable{

    private final String threadName;

    public HelloRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Hello a runnable thread started!");
    }
}
