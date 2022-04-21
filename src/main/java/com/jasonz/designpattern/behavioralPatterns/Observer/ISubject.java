package com.jasonz.designpattern.behavioralPatterns.Observer;

public interface ISubject
{
	public void register(IObserver o);
	public void unregister(IObserver o);
	public void notifyObserver();
}
