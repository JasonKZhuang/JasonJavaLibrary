package com.jasonz.designpattern.behavioralPatterns.Command;

public class TVRemote
{
	public static IElectronicDevice getDevice()
	{
		return new Television();
	}
}
