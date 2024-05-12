package com.jasonz.advancedFeatures.concurrency.notify;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @author Jason Zhuang
 * @created 2024.04.19 13:34
 * @project JasonJavaLibrary
 * @description:
 */
@Slf4j
public class MyThreadTask implements Runnable {

    private final String taskName;
    private final Function<String, String> function;

    public MyThreadTask(String taskName, Function<String, String> function) {
        this.taskName = taskName;
        this.function = function;
    }

    @Override
    public void run() {
        try {
            log.info("Inside thread: " + function.apply(taskName));
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
