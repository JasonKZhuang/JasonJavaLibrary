/**
 * An Asynchronous call does not block the program from the code execution. 
 * When the call returns from the event, the call returns back to the callback function. 
 * 
 * So in the context of Java, we have to Create a new thread and invoke the callback method inside that thread. 
 * The callback function may be invoked from a thread but is not a requirement. 
 * A Callback may also start a new thread, thus making themselves asynchronous.
 *
 * When To Use Asynchronous Callback : 
 * When the tasks are not dependent on each other
 * and may take some time for execution we should use Asynchronous callbacks.
 * For example : When you order your food other people can also order their food in the restaurant. 
 * They don’t have to wait for your order to finish.
 * 
 * * References:
 * https://www.javaworld.com/article/2077462/learn-java/java-tip-10–implement-callback-routines-in-java.html
 */
package com.jasonz.oop.callback;

public class TestASynCallback
{

	private AsynCallbackEventListener mListener; // listener field

	// setting the listener
	public void registerMyEventListener(AsynCallbackEventListener mListener)
	{
		this.mListener = mListener;
	}

	// My Asynchronous task
	public void doSomeThing()
	{
		// An Async task always executes in new thread
		new Thread(new Runnable()
		{
			public void run()
			{
				// perform any operation
				System.out.println("begin=>Performing operation in Asynchronous Task");

				// check if listener is registered.
				if (mListener != null)
				{
					// invoke the callback method of class A
					mListener.onSomeEvent();
				}
				
				System.out.println("End=>Performing operation in Asynchronous Task");
			}
			
		}).start();
		
		System.out.println("====>DoSomeThing method Finished");
	}

	// Driver Program
	public static void main(String[] args)
	{
		TestASynCallback obj = new TestASynCallback();
		
		//1. Define the methods in an interface that we want to invoke after callback.
		//2. Define a class that will implement the callback methods of the interface.
		AsynCallbackEventListener mListener = new AsynCallbackEventListenerImpl();
		//3. Define a reference in other class to register the callback interface.
		obj.registerMyEventListener(mListener);
		//4. Use that reference to invoke the callback method.
		obj.doSomeThing();
	}

}
