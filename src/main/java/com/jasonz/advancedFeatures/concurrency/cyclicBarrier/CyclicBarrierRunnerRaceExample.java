package com.jasonz.advancedFeatures.concurrency.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Jason Zhuang
 * @created 2024.03.10 10:40
 * @project JasonJavaLibrary
 * @description:
 */

public class CyclicBarrierRunnerRaceExample {

    // 定义一个CyclicBarrier实例，指定当三个参与者都到达屏障时，执行的动作。
    private static final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("所有运动员准备就绪，比赛开始！");
        }
    });

    public static void main(String[] args) {
        // 创建并启动三个线程，模拟三个运动员
        for (int i = 1; i <= 3; i++) {
            Thread runner = new Thread(new Runner(i));
            runner.start();
        }
    }

    static class Runner implements Runnable {
        private final int id;

        public Runner(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("运动员" + id + "准备就绪。");
                // 等待其他线程都到达屏障
                barrier.await();
                System.out.println("运动员" + id + "开始跑步！");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
