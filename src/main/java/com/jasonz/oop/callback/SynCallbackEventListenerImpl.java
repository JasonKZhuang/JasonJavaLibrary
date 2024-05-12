package com.jasonz.oop.callback;

public class SynCallbackEventListenerImpl implements SynCallbackEventListener
{
	public void onSomeEvent()
	{
		System.out.println("Performing callback after synchronous Task"); 
        // perform some routine operation 
		try
		{
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
	
    // some class Lesson6Distinct methods
}
