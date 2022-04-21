package com.jasonz.designpattern.behavioralPatterns.Observer;

public class MainTestClient
{

	public MainTestClient()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		PublisherStockGrabber sg = new PublisherStockGrabber();
		
		ConcerateObserverStock observer1 
		= new ConcerateObserverStock(sg);
		
		sg.setIbmPrice(100.00);
		sg.setApplePrice(200.33);
		sg.setGooglePrice(400.33);
		
		ConcerateObserverStock observer2 
		= new ConcerateObserverStock(sg);
		
		sg.setIbmPrice(110.00);
		sg.setApplePrice(220.33);
		sg.setGooglePrice(410.33);
		
		sg.unregister(observer1);
		
		sg.setIbmPrice(333.00);
		sg.setApplePrice(222.33);
		sg.setGooglePrice(444.33);
		
		Runnable getIBM = new UsingThread(sg, 2, "IBM", 222.22);
		Runnable getAPPLE = new UsingThread(sg, 2, "APPLE", 333.33);
		Runnable getGOOGLE = new UsingThread(sg, 2, "GOOGLE", 444.44);
		
		getIBM.run();
		//getAPPLE.run();
		//getGOOGLE.run();
	}

}
