package com.jasonz.advancedFeatures.concurrency.runnableThread;

import lombok.RequiredArgsConstructor;

/**
 * @creator Kaizhi Zhuang
 * @create-time 2013-6-24
 * @writer zhuangkaizhi.com
 * @description :
 * <p>
 * 通过实现Runnable接口中的run()方法
 * the benefit of implementing runnable interface is that
 * this class can extend other parent class,
 * and can implement any other interface if you want.
 * so, highly recommend to use Runnable interface.
 * </p>
 */
@RequiredArgsConstructor
public class ImplementsRunnableExample implements Runnable {

    private final Integer threadID;
    private final String threadName;

    // synchronized 同步关键字 使各个线程排队执行run()方法
    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        // synchronized public void run() {
        int count1 = 0;
        int count2 = 0;
        try {
            while (true) {
                switch (threadID) {
                    case 1:
                        if (count1 > 4) {
                            break;
                        }
                        System.out.println("运行线程1调用的其他方法-线程: " + threadID + " count:" + count1);
                        if (count1 > 3) {
                            throw new RuntimeException("too many times in thread 1, this thread is stopped.");
                        }
                        count1++;
                        break;
                    case 2:
                        if (count2 > 5) {
                            break;
                        }
                        System.out.println("运行线程2调用的其他方法-线程: " + threadID + " count:" + count2);
                        count2++;
                        break;
                    default:
                        System.out.println(String.format("运行线程 [%d] 调用的其他方法-线程 count [%d]: ",threadID, count2));
                        break;
                }

                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
