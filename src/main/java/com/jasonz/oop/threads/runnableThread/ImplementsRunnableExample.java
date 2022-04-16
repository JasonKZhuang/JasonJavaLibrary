package com.jasonz.oop.threads.runnableThread;

/**
 * @creator Kaizhi Zhuang
 * @create-time 2013-6-24
 * @writer zhuangkaizhi.com
 * @description :
 * <p>
 *  通过实现Runnable接口中的run()方法
 *  the benefit of implementing runnable interface is that
 *  this class can extend other parent class,
 *  and can implement any other interface if you want.
 *  so, highly recommend to use Runnable interface.
 * </p>
 */
public class ImplementsRunnableExample implements Runnable {

    private int threadID = 0;
    private String threadName;

    public ImplementsRunnableExample(int threadID, String threadName) {
        this.threadID = threadID;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int count1 = 0;
        int count2 = 0;
        while (true) {
            if (threadID == 1) {
                if (count1 > 4) {
                    break;
                }
                System.out.println("运行线程1调用的其他方法-线程: " + threadID + " count:" + count1);
                if (count1>3){
                    throw new RuntimeException("too many times in thread 1, this thread is stopped.");
                }
                count1++;
            }
            if (threadID == 2) {
                if (count2 > 5) {
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
