package com.jasonz.designpattern.behavioralPatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class PlayWithRemote
{
	public PlayWithRemote()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		IElectronicDevice newDevice = TVRemote.getDevice();
		
		//=================================
		TurnTVOn onCommand = new TurnTVOn(newDevice);
		
		onCommand.execute();
		
//		DeviceButtion btnPressed = new DeviceButtion(onCommand);
//		
//		btnPressed.press();
		
		//----------------------------------
		TurnTVOff offCommand = new TurnTVOff(newDevice);
		
		offCommand.execute();
		
//		btnPressed = new DeviceButtion(offCommand);
//		
//		btnPressed.press();
		
		//----------------------------------
		TurnVolumeUp upCommand = new TurnVolumeUp(newDevice);
		
		upCommand.execute();
		upCommand.execute();
		upCommand.execute();
		
//		btnPressed = new DeviceButtion(upCommand);
//		
//		btnPressed.press();
//		btnPressed.press();
//		btnPressed.press();
		
		//--------------------------------
		Television myTV = new Television();
		Radio myRadio = new Radio();
		
		List<IElectronicDevice> devices = new ArrayList<IElectronicDevice>();
		devices.add(myTV);
		devices.add(myRadio);
		
		TurnAllOn turnOn = new TurnAllOn(devices);
		DeviceButtion btnDevice = new DeviceButtion(turnOn);
		btnDevice.press();
		///
		btnDevice.lift();
		
	}
	
}
