package com.jasonz.designpattern.behavioralPatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class TurnAllOff implements ICommand
{
	List<IElectronicDevice> theDevices = new ArrayList<IElectronicDevice>()	;
	
	public TurnAllOff(List<IElectronicDevice> newDevices)
	{
		this.theDevices = newDevices;
	}

	@Override
	public void execute()
	{
		for(IElectronicDevice device: theDevices)
		{
			device.off();
		}
	}

	@Override
	public void undo()
	{
		for(IElectronicDevice device: theDevices)
		{
			device.on();
		}
		
	}

}
