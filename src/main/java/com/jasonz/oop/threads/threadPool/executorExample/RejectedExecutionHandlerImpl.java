package com.jasonz.oop.threads.threadPool.executorExample;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 建自己的RejectedExecutionHandler实现来处理不适合工作队列的作业
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected====================");
    }

}

