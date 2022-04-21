package com.jasonz.designpattern.behavioralPatterns.Command;

public class TurnTVOff implements ICommand
{
	private IElectronicDevice theDevice;
	
	public TurnTVOff(IElectronicDevice newDevice)
	{
		this.theDevice = newDevice;
	}

	@Override
	public void execute()
	{
		theDevice.off();
	}

	@Override
	public void undo()
	{
		theDevice.on();
		
	}

}
