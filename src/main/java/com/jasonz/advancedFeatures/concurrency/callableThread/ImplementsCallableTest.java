package com.jasonz.advancedFeatures.concurrency.callableThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : Jason Zhuang
 * @date : 24/4/2022
 * @description :
 * 使用继承方式的好处是方便传参，你可以在子类里面添加成员变量，通过 set 方法设置参数或者通过构造函数进行传递，
 * 而如果使用 Runnable 方式，则只能使用主线程里面被声明为 final 的变量。
 * 不好的地方是 Java 不支持多继承，如果继承了 Thread 类，那么子类不能再继承其他类，
 * 而 Runnable 则没有这个限制。
 * 前两种方式都没办法拿到任务的返回结果，但是 Callable 方式可以
 */
public class ImplementsCallableTest {

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<String>(new ImplementsCallableExample());
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
