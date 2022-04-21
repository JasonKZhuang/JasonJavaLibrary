package com.jasonz.designpattern.behavioralPatterns.Observer;

import java.text.DecimalFormat;

public class UsingThread implements Runnable
{
	private int startTime;

	private String stock;

	private double price;

	private ISubject stockSubject;

	public UsingThread(ISubject stockSubject, int newStartTime,
			String newStock, double newPirce)
	{
		this.stockSubject = stockSubject;
		this.startTime = newStartTime;
		this.stock = newStock;
		this.price = newPirce;

	}

	@Override
	public void run()
	{
		for (int i = 0; i <= 20; i++)
		{
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {}
			
			double randNum = (Math.random() * (0.06)) - 0.03;
			
			DecimalFormat df = new DecimalFormat("#.##");
			
			price = Double.valueOf(df.format(price+ randNum));
			
			if (stock.equals("IBM"))
			{
				((PublisherStockGrabber)stockSubject)
				.setIbmPrice(price);
			}
			if (stock.equals("APPLE"))
			{
				((PublisherStockGrabber)stockSubject)
				.setApplePrice(price);
			}
			if (stock.equals("GOOGLE"))
			{
				((PublisherStockGrabber)stockSubject)
				.setGooglePrice(price);
			}
			
//			System.out.println(stock+":"
//					+ df.format(price+randNum)+" "
//					+ df.format(randNum));
		}
	}

}
