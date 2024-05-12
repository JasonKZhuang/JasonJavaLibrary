package com.jasonz.advancedFeatures.concurrency.threadExtends;

import lombok.RequiredArgsConstructor;

/**
 * @creator Kaizhi Zhuang
 * @create-time 2013-6-24
 * @writer zhuangkaizhi.com
 * @description :
 * <p>
 *  这一方法继承Thread类来实现多线程,
 *  Thread class is actually implement runnable interface
 *  通过继承Thread类,并实现它的抽象方法run()
 *  适当时候创建这一Thread子类的实例来实现多线程机制
 *  一个线程启动后（也即进入就绪状态）一旦获得CPU将自动调用它的run()方法
 * </p>
 */
@RequiredArgsConstructor
public class ExtendsThreadExample extends Thread {

    private final Integer threadID;
    private final String threadName;

    // 如果该run()方法顺序执行完了,线程将自动结束,而不会被主线程杀掉
    // 但如果休眠时间过长,则线程还存活,可能被stop()杀掉
    @Override
    public void run() {
        int count1 = 0;
        int count2 = 0;
        while (true) {
            if (threadID == 1) {
                if (count1 > 100) {
                    break;
                }
                System.out.println("运行线程1调用的其他方法-线程: " + threadID + " count:" + count1);
                count1++;
            }
            if (threadID == 2) {
                if (count2 > 100) {
                    break;
                }
                System.out.println("运行线程2调用的其他方法-线程: " + threadID + " count:" + count2);
                count2++;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
