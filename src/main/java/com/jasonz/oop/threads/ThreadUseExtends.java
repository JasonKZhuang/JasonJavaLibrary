package com.jasonz.oop.threads;
/**
 * @creator Peter Zhuang
 * @create-time 2013-6-24
 * copywrite kkcms.com
 */
//通过继承Thread类,并实现它的抽象方法run()
//适当时候创建这一Thread子类的实例来实现多线程机制
//一个线程启动后（也即进入就绪状态）一旦获得CPU将自动调用它的run()方法
public class ThreadUseExtends extends Thread
{
	ThreadUseExtends()
	{
	}// 构造函数

	public void run()
	{
		System.out.println("我是Thread子类的线程实例!");
		System.out.println("我将挂起10秒!");
		System.out.println("回到主线程,请稍等,刚才主线程挂起可能还没醒过来！");
		try
		{
			sleep(10000);// 挂起5秒
		} catch (InterruptedException e)
		{
			return;
		}
		// 如果该run()方法顺序执行完了,线程将自动结束,而不会被主线程杀掉
		// 但如果休眠时间过长,则线程还存活,可能被stop()杀掉
	}
}