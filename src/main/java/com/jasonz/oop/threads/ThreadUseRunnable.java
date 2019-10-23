package com.jasonz.oop.threads;

/**
 * @creator Peter Zhuang
 * @create-time 2013-6-24 copywrite kkcms.com
 */
// 通过实现Runnable接口中的run()方法,再以这个实现了run()方法的类
// 为参数创建Thread的线程实例
public class ThreadUseRunnable implements Runnable

{
	// Thread thread2=new Thread(this);
	// 以这个实现了Runnable接口中run()方法的类为参数创建Thread类的线程实例
	ThreadUseRunnable()
	{
	}// 构造函数

	public void run()
	{
		System.out.println("我是Thread类的线程实例并以实现了Runnable接口的类为参数!");
		System.out.println("我将挂起1秒!");
		System.out.println("回到主线程,请稍等 jn0-120 e20-040 ,刚才主线程挂起可能还没醒过来！");
		try
		{
			Thread.sleep(1000);// 挂起5秒
		} catch (InterruptedException e)
		{
			return;
		}
		// 如果该run()方法顺序执行完了,线程将自动结束,而不会被主线程杀掉
		// 但如果休眠时间过长,则线程还存活,可能被stop()杀掉
	}
	

}