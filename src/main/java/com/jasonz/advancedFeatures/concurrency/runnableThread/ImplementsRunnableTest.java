package com.jasonz.advancedFeatures.concurrency.runnableThread;


/**
 * 该方法使用实现Runnable类来达到多线程目的
 * zhuangkaizhi
 * 2010-3-25
 */
public class ImplementsRunnableTest
{
	public static void main(String args[])
	{
		ImplementsRunnableExample threadExample1 = new ImplementsRunnableExample(1,"First Thread");
		Thread myThread1 = new Thread(threadExample1);
		myThread1.start();

//		try {
//			// waiting for this thread to be finished, then will execute other thread
//			myThread1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		ImplementsRunnableExample threadExample2 = new ImplementsRunnableExample(2,"Second Thread");
		Thread myThread2 = new Thread(threadExample2);
		myThread2.start();

		System.out.println("Does the first thread alive? " + myThread1.isAlive());


	}

}
