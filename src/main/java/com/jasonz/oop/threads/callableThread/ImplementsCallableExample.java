package com.jasonz.oop.threads.callableThread;

import java.util.concurrent.Callable;

public class ImplementsCallableExample implements Callable {

    @Override
    public Object call() throws Exception {
        return "hello world";
    }
}
