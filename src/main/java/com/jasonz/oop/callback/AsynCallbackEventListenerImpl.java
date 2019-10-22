package com.jasonz.oop.callback;

public class AsynCallbackEventListenerImpl implements AsynCallbackEventListener
{
	public void onSomeEvent()
	{
		try
		{
			for (int i = 0; i < 5; i++)
			{
				Thread.sleep(1000);
				System.out.println("Performing callback after Asynchronous Task:" + i);
			}

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
