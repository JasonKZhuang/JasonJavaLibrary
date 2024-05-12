package com.jasonz.advancedFeatures.concurrency.threadCallable;

import java.util.concurrent.Callable;

public class ImplementsCallableExample implements Callable {

    @Override
    public Object call() throws Exception {
        return "hello world";
    }
}
