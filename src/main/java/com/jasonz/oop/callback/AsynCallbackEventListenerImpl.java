package com.jasonz.oop.callback;

public class AsynCallbackEventListenerImpl implements AsynCallbackEventListener
{
	TestASynCallback testMain ;

	public AsynCallbackEventListenerImpl(TestASynCallback argTestMain){
		this.testMain = argTestMain;
	}

	public void onSomeEvent()
	{
		int sum =0;
		try
		{
			for (int i = 0; i < 5; i++)
			{
				Thread.sleep(1000);
				sum ++;
				System.out.println("===> Performing callback after Asynchronous Task:" + i);
			}

			System.out.println("End =>Performing operation in Asynchronous Task");
			this.testMain.doThirdThing(sum);

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
