package com.jasonz.oop.threads;


/**
 * 该方法使用实现Runnable类来达到多线程目的
 * zhuangkaizhi
 * 2010-3-25
 * MyThread.java
 * 在这里输入描述
 */
public class TestImplementsRunnable implements Runnable
{
	private int number;
	public TestImplementsRunnable(int num)
	{
		this.number=num;
		System.out.println("由构造函数创建线程 " + number);
	}
	
	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("thread "+number);
	}
	public static void main(String args[])
	{
		new Thread(new TestImplementsRunnable(1)).start();
		new Thread(new TestImplementsRunnable(2)).start();
	}

}
