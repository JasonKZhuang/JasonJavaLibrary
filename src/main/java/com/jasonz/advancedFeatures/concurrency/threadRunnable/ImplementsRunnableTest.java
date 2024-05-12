package com.jasonz.advancedFeatures.concurrency.threadRunnable;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 该方法使用实现Runnable类来达到多线程目的
 * zhuangkaizhi
 * 2010-3-25
 */
public class ImplementsRunnableTest {

    public static void main(String[] args) {
        ImplementsRunnableTest test = new  ImplementsRunnableTest();
        test.test1();
        //test.testDynamicImplementationAndThreadStart();
        //test.test3();
    }

    private void test11(){
        Runnable barrierAction = () -> System.out.println("Barrier");
        CyclicBarrier barrier = new CyclicBarrier(2, barrierAction);
        Runnable task = () -> {
            try {
                barrier.await();
                barrier.await();
                System.out.println("My task");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
    }


    /**
     * outer Runnable Implementation class
     */
    private void test1(){

        ImplementsRunnableExample threadExample1 = new ImplementsRunnableExample(1, "First Thread");
        Thread myThread1 = new Thread(threadExample1);
        myThread1.start();

        //		try {
        //			// waiting for this thread to be finished, then will execute other thread
        //			myThread1.join();
        //		} catch (InterruptedException e) {
        //			e.printStackTrace();
        //		}

        ImplementsRunnableExample threadExample2 = new ImplementsRunnableExample(2, "Second Thread");
        Thread myThread2 = new Thread(threadExample2);
        myThread2.start();

        System.out.println("Does the first thread alive? " + myThread1.isAlive());

    }

    /**
     * using dynamic implementation and Thread to start
     */
    private void testDynamicImplementationAndThreadStart(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };
        Thread thread = new Thread(r);
        thread.start();
    }

    /**
     * using dynamic implementation and ExecutorService to execute runnable thread
     */
    private void test3(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(r);
        es.submit(r);
    }
}
