package com.jasonz.designpattern.behavioralPatterns.Observer;

import java.util.ArrayList;

public class PublisherStockGrabber implements ISubject
{
	private ArrayList<IObserver> observers;
	private double ibmPrice;
	private double applePrice;
	private double googlePrice;

	public PublisherStockGrabber()
	{
		observers = new ArrayList<IObserver>();
	}

	@Override
	public void register(IObserver newObserver)
	{
		observers.add(newObserver);
	}

	@Override
	public void unregister(IObserver newObserver)
	{
		int obsIdx = observers.indexOf(newObserver);
		observers.remove(obsIdx);
	}

	@Override
	public void notifyObserver()
	{
		for(IObserver observer: observers)
		{
			observer.update(ibmPrice, applePrice, googlePrice);
		}
	}

	public double getIbmPrice()
	{
		return ibmPrice;
	}

	public void setIbmPrice(double ibmPrice)
	{
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}

	public double getApplePrice()
	{
		return applePrice;
	}

	public void setApplePrice(double applePrice)
	{
		this.applePrice = applePrice;
		notifyObserver();
	}

	public double getGooglePrice()
	{
		return googlePrice;
	}

	public void setGooglePrice(double googlePrice)
	{
		this.googlePrice = googlePrice;
		notifyObserver();
	}
	
	
	

}
