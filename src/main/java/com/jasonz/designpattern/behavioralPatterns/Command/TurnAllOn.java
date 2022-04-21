package com.jasonz.designpattern.behavioralPatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class TurnAllOn implements ICommand
{
	List<IElectronicDevice> theDevices = new ArrayList<IElectronicDevice>()	;
	
	public TurnAllOn(List<IElectronicDevice> newDevices)
	{
		this.theDevices = newDevices;
	}

	@Override
	public void execute()
	{
		
	}

	@Override
	public void undo()
	{
		for(IElectronicDevice device: theDevices)
		{
			device.off();
		}
		
	}

}
