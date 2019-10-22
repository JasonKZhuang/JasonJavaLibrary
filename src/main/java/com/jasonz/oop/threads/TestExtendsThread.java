package com.jasonz.oop.threads;


public class TestExtendsThread extends Thread
{
	/*
	 * 这一方法继承Thread类来实现多线程
	 */
	private int theadNum=0;
	
	public TestExtendsThread(int theadNum)
	{
		super();
		this.theadNum = theadNum;
	}

	public static void main(String[] args)
	{
		TestExtendsThread t1 = new TestExtendsThread(1);
		System.out.println("线程1状态(NEW状态):"+t1.getState());
		t1.start();
		System.out.println("线程1状态(就绪状态):"+t1.getState());
		
		TestExtendsThread t2 = new TestExtendsThread(2);
		t2.start();
		
		try
		{
			System.out.println("主线程停止5!");
			Thread.sleep(1000*5);
			
			Thread mainThread = Thread.currentThread();
			System.out.println("main thread priority is "+mainThread.getPriority());
			System.out.println("t1 thread priority is "+t1.getPriority());
			System.out.println("t2 thread priority is "+t2.getPriority());
			
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}

	public void run()
	{
		while(true) 
		{
			if (theadNum==1)
				System.out.println("运行线程1调用的其他方法      线程: " +theadNum );
			if (theadNum==2)
				System.out.println("运行线程2调用的其他方法      线程: " +theadNum );
			
			try
			{
				sleep(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}

	}

}
