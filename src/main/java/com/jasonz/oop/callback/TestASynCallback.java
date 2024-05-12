/**
 * An Asynchronous call does not block the program from the code execution. 
 * When the call returns from the event, the call returns back to the callback function. 
 * 
 * So in the context of Java, we have to Create a new thread and invoke the callback method inside that thread. 
 * The callback function may be invoked from a thread but is not a requirement. 
 * Lesson6Distinct Callback may also start a new thread, thus making themselves asynchronous.
 *
 * When To Use Asynchronous Callback : 
 * When the tasks are not dependent on each other
 * and may take some time for execution we should use Asynchronous callbacks.
 * For example : When you order your food other people can also order their food in the restaurant. 
 * They don’t have to wait for your order to finish.
 * 
 * * References:
 * https://www.javaworld.com/article/2077462/learn-java/java-tip-10–implement-callback-routines-in-java.html
 *
 * 异步调用是为了解决同步调用可能出现阻塞，导致整个流程卡住而产生的一种调用方式。
 * 类 Lesson6Distinct 的 a() 通过新起线程的方式调用类 B 的 b()，代码接着直接往下执行，这样无论 b() 执行时间多久，都不会阻塞住 a() 的执行。
 * 但是，由于 a() 不等待 b() 的执行完成，在 a() 需要 b() 执行结果的情况下(视具体业务而定，有些业务比如启异步线程发个微信通知、刷新缓存这种就没必要)，
 * 必须通过一定的方式对 b() 的执行结果进行监听。
 * Java 中，可以使用 Future+Callable 的方式做到这一点。
 *
 */
package com.jasonz.oop.callback;

/**
 * for this example:
 * 类 Lesson6Distinct 的 a() 通过 B 接口的引用 -> 调用类 B 的 b()
 * 类 B 的 b() 执行完毕主动 回调用类 Lesson6Distinct 的 callback()
 */
public class TestASynCallback
{

	private AsynCallbackEventListener mListener; // listener field

	// setting the listener
	public void registerMyEventListener(AsynCallbackEventListener mListener)
	{
		this.mListener = mListener;
	}

	// My Asynchronous task
	public void doFirstThing(){
		System.out.println("=====> Do the first thing.");
	}

	// My Asynchronous task
	public void doAsynchronousThing()
	{
		// An Async task always executes in new thread
		new Thread(new Runnable()
		{
			public void run()
			{
				// perform any operation
				System.out.println("begin =>Performing operation in Asynchronous Task");

				// check if listener is registered.
				if (mListener != null)
				{
					// invoke the callback method of class Lesson6Distinct
					mListener.onSomeEvent();
				}

			}
			
		}).start();
	}

	// this method is called by callback
	public void doThirdThing(int arg)
	{
		System.out.println("====> Do something after callback in main class. the result from callback is " + arg);
	}

	// Driver Program
	public static void main(String[] args)
	{
		TestASynCallback obj = new TestASynCallback();
		obj.doFirstThing();
		//1. Define the methods in an interface that we want to invoke after callback.
		//2. Define a class that will implement the callback methods of the interface.
		AsynCallbackEventListener mListener = new AsynCallbackEventListenerImpl(obj);
		//3. Define a reference in other class to register the callback interface.
		obj.registerMyEventListener(mListener);
		//4. Use that reference to invoke the callback method.
		obj.doAsynchronousThing();
	}

}
