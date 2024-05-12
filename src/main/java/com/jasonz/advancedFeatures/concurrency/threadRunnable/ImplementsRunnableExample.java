package com.jasonz.advancedFeatures.concurrency.threadRunnable;

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
public class ImplementsRunnableExample implements Runnable {

    private final Integer threadID;
    private final String threadName;

    private boolean stopFlag = false;

    public ImplementsRunnableExample(Integer threadID, String threadName) {
        this.threadID = threadID;
        this.threadName = threadName;
    }

    // synchronized 同步关键字 使各个线程排队执行run()方法
    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        stopFlag = false;
        // synchronized public void run() {
        int count1 = 0;
        int count2 = 0;
        while (!stopFlag) {
            switch (threadID) {
                case 1:
                    System.out.printf("运行线程1调用的其他方法-线程ID:[%d], thread Name:[%s], count: [%d] %n", threadID, threadName, count1);
                    if (count1 > 3) {
                        throw new RuntimeException("too many times in thread 1, this thread is stopped.");
                    }
                    count1++;
                    break;
                case 2:
                    System.out.printf("运行线程2调用的其他方法-线程ID:[%d], thread Name:[%s], count: [%d] %n", threadID, threadName, count2);
                    if (count2 > 5) {
                        stopFlag = true;
                        break;
                    }
                    count2++;
                    break;
                default:
                    System.out.println("Nothing");
                    stopFlag = true;
                    break;
            }
        }

    }


}
