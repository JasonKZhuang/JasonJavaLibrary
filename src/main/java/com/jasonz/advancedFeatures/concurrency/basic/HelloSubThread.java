package com.jasonz.advancedFeatures.concurrency.basic;

import lombok.Getter;

/**
 * @author Jason Zhuang
 * @created 2024.05.09 11:58
 * @project JasonJavaLibrary
 * @description:
 */
@Getter
public class HelloSubThread extends Thread{

    private final String threadName;

    public HelloSubThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        System.out.println("Hello a sub class thread started!");
    }

}
