package com.jasonz.designpattern.behavioralPatterns.Command;

public class Radio implements IElectronicDevice
{
	private int volume = 0;
	
	private String stateOfRadio ="on";
	
	public Radio()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void on()
	{
		System.out.println("Radio is on.");
		stateOfRadio="on";

	}

	@Override
	public void off()
	{
		System.out.println("Radio is off.");
		stateOfRadio="off";
	}

	@Override
	public void volumeUp()
	{
		volume ++;
		System.out.println("Radio Volume is at " + volume);

	}

	@Override
	public void volumeDown()
	{
		volume --;
		System.out.println("Radio Volume is at " + volume);
	}

	public String getStateOfRadio()
	{
		return stateOfRadio;
	}

	public void setStateOfRadio(String stateOfRadio)
	{
		this.stateOfRadio = stateOfRadio;
	}
	
	

}
