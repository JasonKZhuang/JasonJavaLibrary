package com.jasonz.oop.threads;


public class TestFourStateThread extends Thread
{

	private int threadNum;
	
	
	
	public TestFourStateThread(int threadNum)
	{
		super();
		this.threadNum = threadNum;
	}


	@Override
	public void run()
	{
		System.out.println("currentThread().getName():"+currentThread().getName());
		while(true) 
		{
			
			if (threadNum ==1)
			{
				System.out.println("1111111111111");
			}else if(threadNum==2)
			{
				System.out.println("2222222222222");
			}else
			{
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			
			try
			{
				sleep(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		TestFourStateThread obj1 = new TestFourStateThread(1);
		TestFourStateThread obj2 = new TestFourStateThread(2);
		System.out.println("第一线程默认优先级:"+obj1.getPriority());
		System.out.println("第二线程默认优先级:"+obj2.getPriority());
		
		//setPriority用于设置线程优先级
		obj1.setPriority(4);
		obj2.setPriority(6);
		obj1.start();
		obj2.start();
		
		System.out.println("obj1.getState   "+obj1.getState());
		System.out.println("obj2.getState   "+obj2.getState());
		
		try
		{
			Thread.sleep(10000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("*****10 seconds after");
		obj1.setPriority(7);
		obj2.setPriority(3);
		
		try
		{
			sleep(10000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("*****第二个 10 seconds after");
		obj1.setPriority(3);
		obj2.setPriority(7);
		
		System.out.println("obj1.getState   "+obj1.getState());
		System.out.println("obj2.getState   "+obj2.getState());
		
	}
}
