package com.jasonz.designpattern.behavioralPatterns.Command;

public class TurnVolumeDown implements ICommand
{
	private IElectronicDevice theDevice;
	
	public TurnVolumeDown(IElectronicDevice newDevice)
	{
		this.theDevice = newDevice;
	}

	@Override
	public void execute()
	{
		theDevice.volumeDown();
	}

	@Override
	public void undo()
	{
		theDevice.volumeUp();
		
	}

}
