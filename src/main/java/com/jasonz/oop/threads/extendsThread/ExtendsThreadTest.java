package com.jasonz.oop.threads.extendsThread;

import com.jasonz.oop.threads.ThreadConstant;

/**
 * // 优先级将决定cpu空出时，那些处于就绪状态的线程, 哪个线程先占领cpu开始运行
 * // 线程运行后是独立运行，各个线程间不再竞争优先级
 * // 优先级范围1到10, refer to ThreadConstant
 * // 新线程继承创建她的父线程优先级,父线程通常有普通优先级 即5 NORM_PRIORITY
 */
public class ExtendsThreadTest {

    public static void main(String[] args) {
        ExtendsThreadExample exampleThread1 = new ExtendsThreadExample(1, "First Thread");
        System.out.println("线程1状态(NEW状态):" + exampleThread1.getState());
        exampleThread1.setPriority(ThreadConstant.LOW_PRIORITY);
        System.out.println("t1 thread priority is " + exampleThread1.getPriority());
        exampleThread1.start();
        System.out.println("线程1状态(RUNNABLE状态):" + exampleThread1.getState());
        // =================================================== //
        ExtendsThreadExample exampleThread2 = new ExtendsThreadExample(2, "Second Thread");
        System.out.println("线程2状态(NEW状态):" + exampleThread2.getState());
        exampleThread2.setPriority(ThreadConstant.HIGH_PRIORITY);
        System.out.println("t2 thread priority is " + exampleThread2.getPriority());
        exampleThread2.start();
        System.out.println("线程2状态(RUNNABLE状态):" + exampleThread2.getState());
        // =================================================== //

        try {
            System.out.println("主线程停止5!");
            Thread.sleep(1000 * 5);
            Thread mainThread = Thread.currentThread();
            System.out.println("main thread priority is " + mainThread.getPriority());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
