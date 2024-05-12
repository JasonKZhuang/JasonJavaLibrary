package com.jasonz.advancedFeatures.concurrency.executors;

import lombok.NonNull;

import java.util.concurrent.Executor;

/**
 * @author Jason Zhuang
 * @created 2024.02.29 10:19
 * @project JasonJavaLibrary
 * @description: this is the fundamental interface, rarely used directly
 */
public class SampleImpExecutors implements Executor {

    @Override
    public void execute(@NonNull Runnable command) {

    }
}
