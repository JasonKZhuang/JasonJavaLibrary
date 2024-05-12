package com.jasonz.advancedFeatures.concurrency.basic;

import com.jasonz.advancedFeatures.concurrency.ThreadConstant;
import com.jasonz.advancedFeatures.concurrency.interrupt.ThreadInterruptSample;
import com.jasonz.advancedFeatures.concurrency.joins.ThreadJoinsExample;
import com.jasonz.advancedFeatures.concurrency.pausingExecution.UsingThreadSleep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicThreadExample {
    public static void main(String[] args) {

        Map<String,Thread> threads = new HashMap<>();
        // a basic runnable thread
        Thread myRunnableThread = new Thread(new HelloRunnable(ThreadConstant.THREAD_NAME_RUNNABLE));
        threads.put(ThreadConstant.THREAD_NAME_RUNNABLE, myRunnableThread);

        // a basic sub-thread
        Thread mySubThread =  new Thread(new HelloSubThread(ThreadConstant.THREAD_NAME_SUB_THREAD));
        threads.put(ThreadConstant.THREAD_NAME_SUB_THREAD, mySubThread);

        // let me feel sleep for a while
        Thread mySeepThread = new Thread(new UsingThreadSleep(ThreadConstant.THREAD_NAME_SLEEP));
        threads.put(ThreadConstant.THREAD_NAME_SLEEP, mySeepThread);

        // this thread will be interrupted
        Thread myinterruptThread = new Thread(new ThreadInterruptSample(ThreadConstant.THREAD_NAME_INTERRUPT));
        threads.put(ThreadConstant.THREAD_NAME_INTERRUPT, myinterruptThread);

        // this is a thread that will be joined with above sleep thread
        Thread myJoinThread = new Thread(new ThreadJoinsExample(ThreadConstant.THREAD_NAME_JOIN, mySeepThread));
        threads.put(ThreadConstant.THREAD_NAME_JOIN, myJoinThread);

        Thread  handleThreads = new Thread(new HandleMultipleThreadsOperation(threads));
        handleThreads.start();

    }


}
