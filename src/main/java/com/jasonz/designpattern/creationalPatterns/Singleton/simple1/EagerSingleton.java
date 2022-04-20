package com.jasonz.designpattern.creationalPatterns.Singleton.simple1;

public class EagerSingleton
{
	private static final EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton(){}
	
	public static EagerSingleton getInstance()
	{
		return instance;
	}
}
