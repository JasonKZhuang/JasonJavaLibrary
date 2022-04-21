package com.jasonz.designpattern.behavioralPatterns.Command;

public class DeviceButtion
{
	ICommand theCommand;
	
	public DeviceButtion(ICommand newCommand)
	{
		this.theCommand = newCommand;
	}
	
	public void press()
	{
		theCommand.execute();
	}

	public void lift()
	{
		theCommand.undo();
	}
}
